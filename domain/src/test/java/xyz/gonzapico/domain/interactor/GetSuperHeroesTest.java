package xyz.gonzapico.domain.interactor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import xyz.gonzapico.domain.executor.PostExecutionThread;
import xyz.gonzapico.domain.executor.ThreadExecutor;
import xyz.gonzapico.domain.repository.SuperHeroesRepository;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * Created by gfernandez on 6/28/17.
 */
@RunWith(MockitoJUnitRunner.class) public class GetSuperHeroesTest {
  private GetSuperHeroes getSuperHeroesUseCase;

  @Mock private ThreadExecutor mockThreadExecutor;
  @Mock private SuperHeroesRepository mockSuperHeroesRepository;
  @Mock private PostExecutionThread mockPostExecutionThread;

  @Before public void setUp() {
    getSuperHeroesUseCase =
        new GetSuperHeroes(mockSuperHeroesRepository, mockThreadExecutor, mockPostExecutionThread);
  }

  @Test public void testGetWeatherObservableCase() {
    getSuperHeroesUseCase.buildUseCaseObservable();

    verify(mockSuperHeroesRepository).getSuperHeroes();
    verifyNoMoreInteractions(mockSuperHeroesRepository);
    verifyZeroInteractions(mockThreadExecutor);
    verifyZeroInteractions(mockPostExecutionThread);
  }
}