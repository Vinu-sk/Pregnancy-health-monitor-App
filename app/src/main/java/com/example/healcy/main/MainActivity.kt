package com.example.healcy.main

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import com.example.healcy.*
import com.example.healcy.api.ApiConfig
import com.example.healcy.preference.UserPreference
import com.example.healcy.emergency.EmergencyActivity
import com.example.healcy.databinding.ActivityMainBinding
import com.example.healcy.education.EducationActivity
import com.example.healcy.login.LoginActivity
import com.example.healcy.maps.MapsActivity
import com.example.healcy.monitoring.MonitoringActivity
import com.example.healcy.preference.SettingPreferences
import com.example.healcy.preference.dataStore
import com.example.healcy.response.UserResponse
import com.example.healcy.theme.ThemeActivity
import com.example.healcy.theme.ThemeViewModel
import com.example.healcy.viewmodelfactory.ViewModelFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var pref: UserPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = UserPreference(this)

        getToken()
        setValid()
        setViewModel()
        setMenu()
        setTheme()
    }

    private fun setTheme() {
        val pref = SettingPreferences.getInstance(dataStore)
        val darkModeViewModel = ViewModelProvider(this, ViewModelFactory(pref))[ThemeViewModel::class.java]
        darkModeViewModel.getThemeSettings().observe(this){isDarkModeActive ->
            if (isDarkModeActive) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

    private fun getToken() {
        val token = pref.getUser().token
        val client = ApiConfig().getApiService().getUser(token)
        client.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
            }
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
            }
        })
    }

    private fun setMenu() {
        binding.cvEducation.setOnClickListener {
            val education = Intent(this, EducationActivity::class.java)
            startActivity(education)
            finish()
        }

        binding.cvMonitoring.setOnClickListener {
            val monitoring = Intent(this, MonitoringActivity::class.java)
            startActivity(monitoring)
            finish()
        }

        binding.cvHospital.setOnClickListener {
            val hospital = Intent(this, MapsActivity::class.java)
            startActivity(hospital)
            finish()
        }

        binding.cvEmergency.setOnClickListener {
            val emergency = Intent(this, EmergencyActivity::class.java)
            startActivity(emergency)
            finish()
        }
    }

    private fun setViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getUser(pref.getUser().token)
        viewModel.isLoading.observe(this){
            showLoading(it)
        }
    }

    private fun setValid() {
//        if(!pref.getUser().isLogin){
//            val login = pref.getUser().isLogin
//            Log.d(TAG, login.toString())
//
//            val i = Intent(this, LoginActivity::class.java)
//            startActivity(i)
//            finish()
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.setting_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_language -> {
                Intent(Settings.ACTION_LOCALE_SETTINGS).also {
                    startActivity(it)
                    finish()
                }
                return true
            }

            R.id.menu_theme -> {
                val i = Intent(this@MainActivity, ThemeActivity::class.java)
                startActivity(i)
                finish()
                return true
            }
            R.id.menu_logout -> {
                pref.logout()
                val i = Intent(this@MainActivity, LoginActivity::class.java)
                Toast.makeText(this, getString(R.string.logout), Toast.LENGTH_SHORT).show()
                i.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(i)
                finish()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading){
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    companion object{
        const val TAG = "extra_tag"
    }
}