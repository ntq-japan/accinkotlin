package vn.com.ntq_solution.app.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import vn.com.ntq_solition.app.R
import vn.com.ntq_solution.data.database.entities.ApplicationEntity
import vn.com.ntq_solution.domain.loggings.Logcat
import vn.com.ntq_solution.presenter.viewmodels.SplashViewModel
import javax.inject.Inject


/**
 * Loading screen content.
 *
 * Splash fragment control the screen animated.
 */
class SplashFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val splashViewModel: SplashViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(SplashViewModel::class.java)

    companion object {
        fun newInstance(): SplashFragment {
            return SplashFragment()
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, state: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_splash, container, false)
        ButterKnife.bind(this, view)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        splashViewModel.subscribeApplication().observe(this, Observer<ApplicationEntity> { application ->
            Logcat.d(SplashFragment::class.simpleName!!, "", application!!.version)
        })
    }
}
