package com.sdrss.githubtrendingrepoapp.main.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.nhaarman.mockito_kotlin.whenever
import com.sdrss.githubtrendingrepoapp.R
import com.sdrss.githubtrendingrepoapp.data.remote.response.RepositoriesResponse
import com.sdrss.githubtrendingrepoapp.main.MainActivity
import com.sdrss.githubtrendingrepoapp.main.SearchResultListAdapter
import com.sdrss.githubtrendingrepoapp.repository.GithubRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.standalone.inject
import org.koin.test.KoinTest
import org.koin.test.declareMock

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest : KoinTest {

    private val mockDataRepository: GithubRepository by inject()

    @Rule
    @JvmField
    val mActivityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java, false, false)

    @Before
    fun setup() {
        declareMock<GithubRepository>() //initially get all declare mock object singleton instance via koin
    }

    @Test
    fun activityLaunches() {
        mActivityTestRule.launchActivity(null)
        //check matched recyclerView id found means ActivityLaunched
        onView(withId(R.id.recyclerView))
            .check(matches(isDisplayed()))
    }

    @ExperimentalCoroutinesApi
    @Test
    fun checkRepositoriesDisplay() {
        val repositories = TrendingRepositoryFactory.makeTrendingRepositoryList(5) //generate dummyDataList with DataFactory
        stubDataRepositoryFetchTrendingRepositories(repositories) //setUp dummyData to Repository
        mActivityTestRule.launchActivity(null)

        checkRepositoriesAreDisplayed(repositories) //Test Data Display case
    }

    private fun checkRepositoriesAreDisplayed(repositories: List<RepositoriesResponse>) {
        repositories.forEachIndexed { index, repository ->
            //while recyclerView Scrolling to index
            onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(index))

            //match scrolled index item has same author value
            onView(RecyclerViewMatcher.withRecyclerView(R.id.recyclerView).atPosition(index))
                .check(matches(hasDescendant(withText(repository.author))))
        }

        //perform clickAction to the position
        onView(withId(R.id.recyclerView))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<SearchResultListAdapter.ViewHolder>(
                    4,
                    ViewActions.click()
                )
            )
    }

    @ExperimentalCoroutinesApi
    private fun stubDataRepositoryFetchTrendingRepositories(repositories: MutableList<RepositoriesResponse>) {
        runBlockingTest {
            whenever(mockDataRepository.fetchData())
                .thenReturn(repositories)
        }
    }

    @After
    fun cleanUp() {
        getKoin().close() //End of execution get all declared mock object singleton instance and close resources.
    }
}
