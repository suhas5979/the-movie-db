package com.lingga.themoviedb.ui.detailmovie

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.lingga.themoviedb.R
import com.lingga.themoviedb.core.ui.BaseFragment
import com.lingga.themoviedb.core.ui.ViewModelFactory
import com.lingga.themoviedb.databinding.FragmentDetailBinding
import com.lingga.themoviedb.utils.ext.observe
import javax.inject.Inject


class DetailFragment : BaseFragment<FragmentDetailBinding>(R.layout.fragment_detail) {

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: DetailViewModel by viewModels { factory }

    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeUi()
    }

    private fun subscribeUi() {
        observe(viewModel.detail(args.id)) {
            Log.d("cekdetail", it.data.toString())
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        appComponent.inject(this)
    }
}