package com.e.este

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class TodayFragment : Fragment() {

    private lateinit var todayTaskListAdapter: TodayTaskListAdapter
    private lateinit var recyclerView: RecyclerView
    private var taskList: MutableList<TodayTask> = ArrayList()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_today, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView = view!!.findViewById(R.id.RV_today_task_list)

        taskList = taskGenerator() as MutableList<TodayTask>

        todayTaskListAdapter = TodayTaskListAdapter(taskList)
        recyclerView.adapter = todayTaskListAdapter
        todayTaskListAdapter.notifyDataSetChanged()

        val layoutManager = LinearLayoutManager(context!!.applicationContext)
        recyclerView.layoutManager = layoutManager
        layoutManager.orientation = LinearLayoutManager.VERTICAL


        // Swipe Delete Item Recycler View
        val itemTouchSimpleCallback: SimpleCallback = object : ItemTouchHelper.SimpleCallback(
                0, ItemTouchHelper.RIGHT
        ){
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                Toast.makeText(context, "action Move", Toast.LENGTH_SHORT).show()

                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                Toast.makeText(context, "action Swipe", Toast.LENGTH_SHORT).show()

                val taskPosition: Int = viewHolder.adapterPosition
                taskList.removeAt(taskPosition)
                todayTaskListAdapter.notifyDataSetChanged()

            }

        }

        val itemTouchHelper = ItemTouchHelper(itemTouchSimpleCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
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