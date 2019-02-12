package com.bw.ymy.a;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class MainActivity extends AppCompatActivity {

    private SimpleDraweeView icon;

    private Button yuanxing,yuanjiao,jt,giff,jianjin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        icon=findViewById(R.id.icon);
        yuanjiao=findViewById(R.id.yuanjiao);
        yuanxing=findViewById(R.id.yuanxing);
        jt=findViewById(R.id.jt);
        giff=findViewById(R.id.giff);
        jianjin=findViewById(R.id.jianjin);
        final Uri uri = Uri.parse("https://www.banbaowang.com/uploads/allimg/190212/32-1Z2121605100-L.jpg");
        SimpleDraweeView yx = icon;
        yx.setImageURI(uri);
        //点击设置为圆形
        yuanxing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                GenericDraweeHierarchy hierarchy=GenericDraweeHierarchyBuilder.newInstance(getResources())
                        //设置为圆形
                        .setRoundingParams(RoundingParams.asCircle())
                        .setFadeDuration(70000)
                        .build();
                icon.setHierarchy(hierarchy);

                Uri uri = Uri.parse("https://www.banbaowang.com/uploads/allimg/190212/32-1Z2121605100-L.jpg");
                SimpleDraweeView yx = icon;
                yx.setImageURI(uri);
            }
        });
        //点击设置为圆角
        yuanjiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                GenericDraweeHierarchy yj=GenericDraweeHierarchyBuilder.newInstance(getResources())
                        //设置为圆jiao
                        .setRoundingParams(RoundingParams.fromCornersRadius(20))
                        .build();
                icon.setHierarchy(yj);

                Uri uri = Uri.parse("https://www.banbaowang.com/uploads/allimg/190212/32-1Z2121605100-L.jpg");
                SimpleDraweeView yx = icon;
                yx.setImageURI(uri);
            }
        });
        //动图
        giff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //加载动图 gif
             Uri gif=Uri.parse("http://www.zhaoapi.cn/images/girl.gif");
                AbstractDraweeController build2 = Fresco.newDraweeControllerBuilder()
                        .setUri(gif).setAutoPlayAnimations(true)
                        .setOldController(icon.getController())
                        .build();
                icon.setController(build2);
            }
        });
        //监听
        jt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击了一下", Toast.LENGTH_SHORT).show();
            }
        });
        //渐进式
        jianjin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GenericDraweeHierarchy q=GenericDraweeHierarchyBuilder.newInstance(getResources())
                        //设置为圆jiao
                       .setFadeDuration(5000)
                        .build();
                icon.setHierarchy(q);

                Uri uri = Uri.parse("https://www.banbaowang.com/uploads/allimg/190212/32-1Z2121605100-L.jpg");
                SimpleDraweeView yx = icon;
                yx.setImageURI(uri);
            }
        });
    }
}
