package com.daivp.play

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.daivp.play.databinding.FragmentFirstBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlin.concurrent.thread

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button1.also {
            it.setOnClickListener {
                Log.d("DDAI","Click")
                binding.textviewFirst.requestFocus()
            }
//            it.setOnTouchListener { _, event ->
//                event.actionMasked
//                Log.d("DDAI","Touch > ${event.action}")
//                false
//            }
        }

        binding.button2.setOnClickListener {
            binding.textview2.requestFocus()
        }
        binding.button3.setOnClickListener {
            binding.textview3.requestFocus()
        }
    }

    private fun test1() {
//        GestureDetector
        ViewConfiguration.getLongPressTimeout()
        GlobalScope.launch(IO){
            testIn1()
        }
    }

    fun test2() = runBlocking {
        launch(Dispatchers.Default,CoroutineStart.DEFAULT) {
            testIn1()
        }
    }

    fun test3() = runBlocking {
        testIn2()
    }

    suspend fun testIn1() {
        delay(2000L)
        binding.textviewFirst.text = "testIn1"
    }

    suspend fun testIn2() = coroutineScope {
        launch {
            delay(1000L)
            println("World!")
            binding.textviewFirst.text = "testIn2"
        }
        println("Hello")
    }


}