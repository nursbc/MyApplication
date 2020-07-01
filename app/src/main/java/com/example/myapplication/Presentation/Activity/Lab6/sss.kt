/*
package kz.education.stepclasswork6

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.RequiresApi

class Task2Activity : AppCompatActivity() {

    private val PERMISSION_CODE = 1000;
    private val IMAGE_CAPTURE_CODE = 1001
    var image_uri: Uri? = null
    var buttonTakePhoto: Button? = null;
    var imageViewResult: ImageView? = null;

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task2)
        initializeElements()
        initializeEventListeners()
    }


    fun initializeElements(){
        buttonTakePhoto = findViewById(R.id.activity_task2_button_take_photo)
        imageViewResult = findViewById(R.id.activity_task2_image_view_result)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun initializeEventListeners(){
        buttonTakePhoto?.setOnClickListener(View.OnClickListener {
            if(!initiateCheckPermissionCamera())
                initiateRequestPermissionsCamera()
            else
                initiateCamera()
        })
    }

    fun initiateCamera(){
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "New Picture")
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera")
        image_uri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
        //camera intent
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri)
        startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun initiateRequestPermissionsCamera(){
        requestPermissions(Array(1){android.Manifest.permission.CAMERA},PERMISSION_CODE)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun initiateCheckPermissionCamera() :Boolean{
        return  checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            PERMISSION_CODE->{
                if(grantResults.isNotEmpty()){
                    initiateCamera()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //called when image was captured from camera intent
        if (resultCode == Activity.RESULT_OK) {
            //set image captured to image view
            imageViewResult?.setImageURI(image_uri)
        }
    }
    }

*/
