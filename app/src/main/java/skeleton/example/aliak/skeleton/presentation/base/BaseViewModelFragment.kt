package skeleton.example.aliak.skeleton.presentation.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

open class BaseViewModelFragment : Fragment() {

    lateinit var viewModel: ViewModelLifecycle

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onResume() {
        super.onResume()
        viewModel.resume()
    }

    override fun onPause() {
        super.onPause()
        viewModel.pause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.release()
    }

}