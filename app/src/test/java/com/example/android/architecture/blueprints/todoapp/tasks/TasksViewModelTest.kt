package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.addedittask.AddEditTaskViewModel
import com.example.android.architecture.blueprints.todoapp.getOrAwaitValue
import org.hamcrest.Matchers.`is`
import org.hamcrest.core.IsNot.not
import org.hamcrest.core.IsNull.nullValue
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TasksViewModelTest{

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var taskViewModel: TasksViewModel

    @Before
    fun setupViewModel(){
        // Given a fresh TasksViewModel
        taskViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())
    }

    @Test
    fun addNewTask_setNewTaskEvent(){
        // Given a fresh TasksViewModel
       // val taskViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())

        // When adding a new task
        taskViewModel.addNewTask()

        // Then the new task event is triggered
        val value = taskViewModel.newTaskEvent.getOrAwaitValue()

        assertThat(value.getContentIfNotHandled(), (not(nullValue())))
    }

    @Test
    fun setFilterAllTasks_taskAddViewVisible(){
        // Given a fresh ViewModel
        //val taskViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())

        // When the filter type is ALL_TASKS
        taskViewModel.setFiltering(TasksFilterType.ALL_TASKS)

        // Then the "Add task" action is visible
        assertThat(taskViewModel.tasksAddViewVisible.getOrAwaitValue(),`is`(true))
    }
}