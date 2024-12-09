package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.service.quicksettings.Tile;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Soical_Page_Info extends AppCompatActivity {
    ImageView User;
    ImageView Weapon;
    ImageView Item;
    ImageView Enemy;
    ImageView Soical;
    ImageView Comment;
    ImageView Save;
    ImageView Likes_Button;
    ImageView Dislikes_Button;
    ImageView Edit;
    TextView Title;
    TextView Body;
    TextView Likes;
    TextView Dislikes;
    TextView Date;
    DatabaseHelper dbhelper;
    static int i;
    boolean clicklikes = false;
    boolean clickdislike = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_soical_page_info);
        User = findViewById(R.id.Soical_v_User);
        Weapon = findViewById(R.id.Soical_v_Weapon);
        Item = findViewById(R.id.Soical_v_Items);
        Enemy = findViewById(R.id.Soical_v_Enemies);
        Soical = findViewById(R.id.Soical_v_Soical);
        Comment = findViewById(R.id.Btn_v_Comments);
        Save = findViewById(R.id.Btn_v_Save);
        Likes_Button = findViewById(R.id.Btn_v_Likes);
        Dislikes_Button = findViewById(R.id.btn_v_Dislikes);
        Title = findViewById(R.id.Soical_v_Title);
        Body = findViewById(R.id.Soical_v_Body);
        Likes = findViewById(R.id.Soical_v_Likes);
        Dislikes = findViewById(R.id.Soical_v_Dislikes);
        Date = findViewById(R.id.Soical_v_date);
        Edit = findViewById(R.id.btn_v_soical_edit);
        dbhelper = new DatabaseHelper(this);
        Intent pass = getIntent();
        i = pass.getIntExtra("Postid", 0);
        Post_info.setIsative(true);

        fillinfo();
        updateLikesandDislikes();
        ifmadebyuser();
    }
    public void ifmadebyuser()
    {
        if(Post_info.getUserid() == LoginUser.getloginuser().getUserid())
        {
            Edit.setVisibility(View.VISIBLE);
            Edit.setClickable(true);
        }
        else
        {
        Edit.setVisibility(View.INVISIBLE);
        Edit.setClickable(false);
        }
    }

    public void fillinfo()
    {
        Post_info pi = dbhelper.getPostinfo(i + 1);
        Title.setText(Post_info.getTitle());
        Body.setText(Post_info.getBody());
        Likes.setText(Post_info.getLikes() + "");
        Dislikes.setText(Post_info.getDislikes() + "");
        Date.setText(Post_info.getDate());
        dbhelper.addhistory(Post_info.getTitle(), Post_info.getPostid(), "Posts", Post_info.getLikes(), Post_info.getDislikes(), LoginUser.getloginuser().getUserid());
    }
    public void updateLikesandDislikes()
    {
        Likes_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!clicklikes) {
                    Post_info.setLikes(Post_info.getLikes() + 1);
                    dbhelper.updatelikes(Post_info.getLikes());
                    Likes.setText(Post_info.getLikes() + "");
                    clicklikes = true;
                }
                else if(clicklikes)
                {
                    Post_info.setLikes(Post_info.getLikes() - 1);
                    dbhelper.updatelikes(Post_info.getLikes());
                    Likes.setText(Post_info.getLikes() + "");
                    clicklikes = false;
                }


            }
        });
        Dislikes_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!clickdislike)
                {
                    Post_info.setDislikes(Post_info.getDislikes()+ 1);
                    dbhelper.updatedislikes(Post_info.getDislikes());
                    Dislikes.setText(Post_info.getDislikes() + "");
                    clickdislike = true;

                }
                else if(clickdislike)
                {
                    Post_info.setDislikes(Post_info.getDislikes() - 1);
                    dbhelper.updatedislikes(Post_info.getDislikes());
                    Dislikes.setText(Post_info.getDislikes() + "");
                    clickdislike = false;
                }
            }
        });
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Post_info.setIsative(false);
            dbhelper.addbookmark(dbhelper.getBookmark_table_name(),"Post");
            startActivity(new Intent(Soical_Page_Info.this, Bookmarkpaged.class));
            }
        });
        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Soical_Page_Info.this, Edit_Post.class));
            }
        });
        Comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Soical_Page_Info.this, Comments_list_page.class));
            }
        });
        User.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Soical_Page_Info.this, User_Page.class));
            }
        });
        Weapon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Soical_Page_Info.this, Weapon_Wiki.class));
            }
        });
        Item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Soical_Page_Info.this, Items_Wiki.class));
            }
        });
        Enemy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Soical_Page_Info.this, Enemies_Wiki.class));
            }
        });
        Soical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Soical_Page_Info.this, Soicals_list_page.class));
            }
        });
    }


}