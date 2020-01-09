package com.thiago.bankapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thiago.bankapp.R
import com.thiago.remote.model.UserDetailModel
import kotlinx.android.synthetic.main.user_account_detail.view.*

class DetailAdapter(): RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {

    var projects: List<UserDetailModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val root: View = LayoutInflater.from(parent.context).inflate(R.layout.user_account_detail, parent, false)
        return DetailViewHolder(root)
    }

    override fun getItemCount(): Int {
        return projects.count()
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val project: UserDetailModel = projects.get(position)
        holder.detailTitle.text = project.title
        holder.detailDate.text = project.date
        holder.detailDescription.text = project.description
        holder.detailValue.text = project.accountValue.toString()
    }

    inner class DetailViewHolder(view: View): RecyclerView.ViewHolder(view){
        var detailTitle: TextView = view.detail_title
        var detailDate: TextView = view.detail_date
        var detailDescription: TextView = view.detail_description
        var detailValue: TextView = view.detail_value
    }
}