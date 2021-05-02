package com.e.este

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class TodayFragment : Fragment() {

    private lateinit var todayTaskListAdapter: TodayTaskListAdapter
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_today, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView = view!!.findViewById(R.id.RV_today_task_list)

        todayTaskListAdapter = TodayTaskListAdapter(taskGenerator())
        recyclerView.adapter = todayTaskListAdapter
        todayTaskListAdapter.notifyDataSetChanged()

        val layoutManager = LinearLayoutManager(context!!.applicationContext)
        recyclerView.layoutManager = layoutManager
        layoutManager.orientation = LinearLayoutManager.VERTICAL
    }

    fun taskGenerator(): List<TodayTask> {

        val list: MutableList<TodayTask> = ArrayList()

        val t1 = TodayTask("Repair laptop")
        val t2 = TodayTask("Do Homework")
        val t3 = TodayTask("Enterprise Arch #6 Assigment")

        list.add(t1)
        list.add(t2)
        list.add(t3)


        return list
    }

}