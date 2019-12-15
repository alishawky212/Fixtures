package com.example.fixturesapplication.view.adapters

import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.domain.models.MatchStatus
import com.example.fixturesapplication.R
import com.example.fixturesapplication.inflate
import com.example.fixturesapplication.model.DateItem
import com.example.fixturesapplication.model.ItemType
import com.example.fixturesapplication.model.ListItem
import com.example.fixturesapplication.model.MatchUIModel
import com.like.LikeButton
import com.like.OnLikeListener
import kotlinx.android.synthetic.main.match_item.view.*
import kotlinx.android.synthetic.main.time_item_card.view.*
import java.io.InputStream
import javax.inject.Inject


private const val TYPE_DATE = 0
private const val TYPE_GENERAL = 1

class MatchesAdapter @Inject constructor(private val requestBuilder: RequestBuilder<PictureDrawable>) : RecyclerView.Adapter<BaseMatchesListViewHolder>(){

    private val matchesList = mutableListOf<ListItem>()

    var favoriteClickHandler:((uiModel: MatchUIModel,isFavorite:Boolean) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseMatchesListViewHolder {
       return when(viewType){
            TYPE_DATE -> DateViewHolder(parent.inflate(R.layout.time_item_card))
           TYPE_GENERAL -> MatchesViewHolder(parent.inflate(R.layout.match_item))
           else -> throw Exception("Not Supported View Type")
        }
    }

    override fun getItemCount() = matchesList.size

    override fun onBindViewHolder(holder: BaseMatchesListViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemViewType(position: Int): Int {
        val item = matchesList[position]
        return when(item.getType()){
            ItemType.TYPE_DATE -> TYPE_DATE
            ItemType.TYPE_GENERAL -> TYPE_GENERAL
        }
    }


    fun setMatchesList(matchesList: List<ListItem>){
        val diffResult = DiffUtil.calculateDiff(MatchesDiffUtilCallback(this.matchesList, matchesList))
        this.matchesList.clear()
        this.matchesList.addAll(matchesList)
        diffResult.dispatchUpdatesTo(this)
    }

    inner class DateViewHolder(view: View):BaseMatchesListViewHolder(view){
        override fun bind() {
            val item = matchesList[adapterPosition] as DateItem
            with(itemView){
                tvDate.text = item.date
            }
        }

    }

    inner class MatchesViewHolder(view: View):BaseMatchesListViewHolder(view){
        override fun bind(){
            val item = matchesList[adapterPosition] as MatchUIModel
            with(itemView){
                when(item.status){
                    MatchStatus.FINISHED -> {
                        timeText.isVisible = false
                        scoreHomeTeam.text = item.result.homeTeam.toString()
                        scoreAwayTeam.text = item.result.awayTeam.toString()
                    }
                    MatchStatus.SCHEDULED,MatchStatus.POSTPONED, MatchStatus.PAUSED,MatchStatus.SUSPENDED,
                    MatchStatus.CANCELED -> {
                        timeText.isVisible = true
                        timeText.text = item.time
                        scoreHomeTeam.text = ""
                        scoreAwayTeam.text = ""
                    }
                    MatchStatus.IN_PLAY,MatchStatus.LIVE -> {
                        timeText.isVisible = true
                        timeText.text = context.getString(R.string.live)
                        scoreHomeTeam.text = item.result.homeTeam.toString()
                        scoreAwayTeam.text = item.result.awayTeam.toString()
                    }
                }
                textHomeTeam.text = item.homeTeam.name
                textAwayTeam.text = item.awayTeam.name

                ivLike.isLiked = item.isFavorite

                requestBuilder
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    // SVG cannot be serialized so it's not worth to cache it
                    .load(Uri.parse(item.awayTeam.teamImage))
                    .into(teamImg)

                ivLike.setOnLikeListener(object :OnLikeListener{
                    override fun liked(likeButton: LikeButton?) {
                        favoriteClickHandler?.invoke(item,true)
                    }

                    override fun unLiked(likeButton: LikeButton?) {
                       favoriteClickHandler?.invoke(item,false)
                    }

                })

            }
        }
    }
}