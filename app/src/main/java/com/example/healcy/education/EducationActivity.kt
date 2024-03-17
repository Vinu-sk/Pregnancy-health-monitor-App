package com.example.healcy.education

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.healcy.R

class EducationActivity : AppCompatActivity() {
    private lateinit var img1: ImageView
    private lateinit var img2: ImageView
    private lateinit var img3: ImageView
    private lateinit var img4: ImageView
    private lateinit var img5: ImageView
    private lateinit var img6: ImageView
    private lateinit var img7: ImageView
    private lateinit var img8: ImageView
    private lateinit var img9: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_education)

        supportActionBar?.title = getString(R.string.education)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setEducation1()
        setEducation2()
        setEducation3()
        setEducation4()
        setEducation5()
        setEducation6()
        setEducation7()
        setEducation8()
        setEducation9()
    }

    private fun setEducation9() {
        img9 = findViewById(R.id.img9)
        img9.setOnClickListener {
            val img9 = Intent(Intent.ACTION_VIEW, Uri.parse("https://edukasi.okezone.com/detail/774245/fakta-vaksin-covid-19-bagi-kesuburan-program-kehamilan"))
            startActivity(img9)
        }
    }

    private fun setEducation8() {
        img8 = findViewById(R.id.img8)
        img8.setOnClickListener {
            val img8 = Intent(Intent.ACTION_VIEW, Uri.parse("https://promkes.kemkes.go.id/pedoman-pemberian-tablet-tambah-darah-ttd-bagi-ibu-hamil-pada-masa-pandemi-covid-19-bagi-tenaga-kesehatan"))
            startActivity(img8)
        }
    }

    private fun setEducation7() {
        img7 = findViewById(R.id.img7)
        img7.setOnClickListener {
            val img7 = Intent(Intent.ACTION_VIEW, Uri.parse("https://edukasi.okezone.com/detail/775025/mengenal-metode-kehamilan-surrogate-metode-ibu-pengganti"))
            startActivity(img7)
        }
    }

    private fun setEducation6() {
        img6 = findViewById(R.id.img6)
        img6.setOnClickListener {
            val img6 = Intent(Intent.ACTION_VIEW, Uri.parse("https://yankes.kemkes.go.id/view_artikel/1092/cegah-stunting-sejak-dalam-masa-kehamilan"))
            startActivity(img6)
        }
    }

    private fun setEducation5() {
        img5 = findViewById(R.id.img5)
        img5.setOnClickListener {
            val img5 = Intent(Intent.ACTION_VIEW, Uri.parse("https://kkn.undip.ac.id/?p=334366"))
            startActivity(img5)
        }
    }

    private fun setEducation4() {
        img4 = findViewById(R.id.img4)
        img4.setOnClickListener {
            val img4 = Intent(Intent.ACTION_VIEW, Uri.parse("https://edukasi.okezone.com/detail/773610/5-olahraga-untuk-ibu-hamil"))
            startActivity(img4)
        }
    }

    private fun setEducation3() {
        img3 = findViewById(R.id.img3)
        img3.setOnClickListener {
            val img3 = Intent(Intent.ACTION_VIEW, Uri.parse("https://covid19.kemkes.go.id/protokol-covid-19/pedoman-bagi-ibu-hamil-ibu-nifas-dan-bbl-selama-social-distancing"))
            startActivity(img3)
        }
    }

    private fun setEducation2() {
        img2 = findViewById(R.id.img2)
        img2.setOnClickListener {
            val img2 = Intent(Intent.ACTION_VIEW, Uri.parse("https://promkes.kemkes.go.id/flyer-menjaga-ibu-hamil-dan-janin-sehat---cerdas"))
            startActivity(img2)
        }
    }

    private fun setEducation1() {
        img1 = findViewById(R.id.img1)
        img1.setOnClickListener {
            val img1 = Intent(Intent.ACTION_VIEW, Uri.parse("https://promkes.kemkes.go.id/flyer-kenali-tanda-bahaya-pada-kehamilan"))
            startActivity(img1)
        }
    }
}