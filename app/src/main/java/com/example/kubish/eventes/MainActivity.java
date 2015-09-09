package com.example.kubish.eventes;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.httpClient.VKAbstractOperation;
import com.vk.sdk.api.methods.VKApiFriends;
import com.vk.sdk.api.methods.VKApiWall;
import com.vk.sdk.api.model.VKApiAudio;
import com.vk.sdk.api.model.VKApiPhoto;
import com.vk.sdk.api.model.VKApiUserFull;
import com.vk.sdk.api.model.VKAttachments;
import com.vk.sdk.api.model.VKList;
import com.vk.sdk.api.model.VKPhotoArray;
import com.vk.sdk.api.model.VKUsersArray;
import com.vk.sdk.api.model.VKWallPostResult;
import com.vk.sdk.api.photo.VKImageParameters;
import com.vk.sdk.api.photo.VKUploadImage;
import com.vk.sdk.api.photo.VKUploadWallPhotoRequest;

public class MainActivity extends AppCompatActivity {


    private static String[] sMyScope = new String[]{VKScope.FRIENDS, VKScope.WALL, VKScope.PHOTOS, VKScope.NOHTTPS, VKScope.AUDIO};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.kubish.eventes.R.layout.activity_main);



    }

    public void pushauthbutton(View v){

      // VKSdk.login(this, sMyScope);
        Intent intent = new Intent(MainActivity.this, EventsActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.example.kubish.eventes.R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == com.example.kubish.eventes.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
            // Пользователь успешно авторизовался
            Toast.makeText(getApplicationContext(), "Authorization Success", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, EventsActivity.class);
                startActivity(intent);

            /*
                Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.testpng);
                int mPhotoWidth = mBitmap.getWidth();
                int mPhotoHeight = mBitmap.getHeight();
                final Bitmap photo = mBitmap;

                VKRequest request = VKApi.uploadWallPhotoRequest(new VKUploadImage(photo, VKImageParameters.jpgImage(0.9f)), 0, 0);
                request.executeWithListener(new VKRequest.VKRequestListener() {
                    @Override
                    public void onComplete(VKResponse response) {
                        photo.recycle();
                        VKApiPhoto photoModel = ((VKPhotoArray) response.parsedModel).get(0);
                        //Make post with photo

                        final VKParameters params = new VKParameters();
                        String name="VK ANDROID TEST";
                        VKAttachments attachments = new VKAttachments();
                        attachments.add(photoModel);
                        params.put(VKApiConst.FRIENDS_ONLY,1);
                        params.put(VKApiConst.MESSAGE,name);
                        params.put(VKApiConst.ATTACHMENTS,attachments);
                        VKRequest currentRequest = VKApi.wall().post(params);
                        currentRequest.executeWithListener(new VKRequest.VKRequestListener() {
                            @Override
                            public void onComplete(VKResponse response) {
                                super.onComplete(response);
                                VKWallPostResult vkWallPostResult = (VKWallPostResult) response.parsedModel;
                                Toast.makeText(getApplicationContext(), "Request Complete" + vkWallPostResult.post_id, Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onError(VKError error) {
                                super.onError(error);
                                Toast.makeText(getApplicationContext(), "Request error post", Toast.LENGTH_LONG).show();
                            }
                        });


                    }
                    @Override
                    public void onError(VKError error) {
                       // showError(error);
                    }
                });


            */

            }
            @Override
            public void onError(VKError error) {
                 Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
