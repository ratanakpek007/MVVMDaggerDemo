package delivery.food.mvvmdemo.trending;

import android.text.TextUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.List;

import delivery.food.mvvmdemo.data.RepoRequester;
import delivery.food.mvvmdemo.data.TrendingReposResponse;
import delivery.food.mvvmdemo.model.Repo;
import delivery.food.mvvmdemo.textutil.TestUtils;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;

import static org.mockito.Mockito.when;

public class TrendingReposPresenterTest {

    @Mock
    RepoRequester repoRequester;
    @Mock
    TrendingReposViewModel viewModel;
    @Mock
    Consumer<Throwable> onErrorConsumer;
    @Mock
    Consumer<List<Repo>> onSuccessConsumer;
    @Mock
    Consumer<Boolean> loadingConsumer;

    private TrendingReposPresenter trendingReposPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(viewModel.loadingUpdated()).thenReturn(loadingConsumer);
        when(viewModel.onError()).thenReturn(onErrorConsumer);
        when(viewModel.reposUpdated()).thenReturn(onSuccessConsumer);
    }

    private void initializePresenter(){
        trendingReposPresenter= new TrendingReposPresenter(viewModel, repoRequester);
    }

    private List<Repo> setUpSuccess(){
        TrendingReposResponse reposResponse= TestUtils.loadJson("/mock/get_trending_repos.json", TrendingReposResponse.class);
        List<Repo> listRepo=reposResponse.repos();
        when(repoRequester.getTrendingRepos()).thenReturn(Single.just(listRepo));
        return listRepo;
    }

   /* private Throwable setUpError()
    {
        Throwable throwable= new IOException();

    }  */
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void onRepoClicked() {
    }
}