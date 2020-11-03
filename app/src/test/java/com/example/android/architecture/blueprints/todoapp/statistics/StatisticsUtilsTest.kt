package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest{

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero(){
        // Create an active tasks (the false makes this active)
        val task = listOf<Task>(
                Task("title","desc",isCompleted = false)
        )

        // Call our function (in the app)
        val result = getActiveAndCompletedStats(task)

        //Check the result
        /*assertEquals(0f,result.completedTasksPercent);
        assertEquals(100f,result.activeTasksPercent);*/

        //using Hamcrest Test
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(100f));
    }

    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty(){
        // Create an active tasks (the false makes this active)
        val task = listOf<Task>(
                Task("title","desc",isCompleted = false),
                Task("title","desc",isCompleted = false),
                Task("title","desc",isCompleted = false),
                Task("title","desc",isCompleted = true),
                Task("title","desc",isCompleted = true)
        )

        // Call our function (in the app)
        val result = getActiveAndCompletedStats(task)

        //Check the result
        assertEquals(40f,result.completedTasksPercent);
        assertEquals(60f,result.activeTasksPercent);
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros(){
        // Create an active tasks (the false makes this active)
        //val task = emptyList<Task>()

        // Call our function (in the app)
        val result = getActiveAndCompletedStats(emptyList())

        //Check the result
        assertEquals(0f,result.completedTasksPercent);
        assertEquals(0f,result.activeTasksPercent);
    }

    @Test
    fun getActiveAndCompletedStats_error_returnsZeros(){
        // Create an active tasks (the false makes this active)
       // val task = null

        // Call our function (in the app)
        val result = getActiveAndCompletedStats(null)

        //Check the result
        assertEquals(0f,result.completedTasksPercent);
        assertEquals(0f,result.activeTasksPercent);
    }
}