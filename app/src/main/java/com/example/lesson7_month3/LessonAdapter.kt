package com.example.lesson7_month3

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lesson7_month3.databinding.ItemLessonBinding

class LessonAdapter (
        private val data: ArrayList<Lesson>, private val context: Context,
        private val onClick: (pos: Int) -> Unit,
        private val onLongClick: (pos: Int) -> Unit
) :
        RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
                return LessonViewHolder(
                        ItemLessonBinding.inflate(
                                LayoutInflater.from(parent.context),
                                parent,
                                false
                        )
                )
        }

        override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
                holder.bind(data[position])
        }

        override fun getItemCount(): Int {
                return data.size
        }


        inner class LessonViewHolder(private val binding: ItemLessonBinding) :
                RecyclerView.ViewHolder(binding.root) {
                fun bind(lesson: Lesson) {
                        itemView.setOnClickListener {
                                onClick(adapterPosition)
                        }
                        itemView.setOnLongClickListener {
                                onLongClick(adapterPosition)
                                false
                        }

                        Glide.with(binding.ivLesson).load(lesson.image).into(binding.ivLesson)
                        binding.tvName.text = lesson.name
                        lesson.backgroundColor?.let {
                                binding.mainContainer.setBackgroundColor(
                                        ContextCompat.getColor(
                                                context,
                                                it
                                        )
                                )
                        }
                        lesson.tbColor?.let {
                                binding.tvName.setBackgroundColor(
                                        ContextCompat.getColor(
                                                context,
                                                it
                                        )
                                )
                        }
                }

        }
}


