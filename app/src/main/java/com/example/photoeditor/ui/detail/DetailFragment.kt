package com.example.photoeditor.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.photoeditor.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.update


fun FragmentDetailBinding.loadFilteredImage(imageView: ImageView) {

}

fun FragmentDetailBinding.loadImage(view: ImageView, isFilterApplied: Boolean) {

}

fun FragmentDetailBinding.setText(text: String) {
    button.text = text
}

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    val args: DetailFragmentArgs by navArgs()

    private val viewModel by viewModels<DetailViewModel>()

    private val filterClickListener by lazy {
        View.OnClickListener {
            if (viewModel.isFilterApplied.value) {
                binding.setText("Apply Filter")
            } else {
                binding.setText("Revert Image")
            }
            viewModel._isFilterApplied.update { !viewModel.isFilterApplied.value }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.filterClickListener = filterClickListener
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args.specieModel.let {
            binding.name = it.species_name
            binding.desc = it.texture
            binding.image = it.species_illustration_photo?.src
        }
    }

}