package com.codepath.android.booksearch.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.android.booksearch.R;
import com.codepath.android.booksearch.models.Book;

import org.parceler.Parcels;

public class BookDetailActivity extends AppCompatActivity {
    private ImageView ivBookCover;
    private TextView tvTitle;
    private TextView tvAuthor;
    Context context;
    Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        // Fetch views
        ivBookCover = (ImageView) findViewById(R.id.ivBookCover);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvAuthor = (TextView) findViewById(R.id.tvAuthor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Extract book object from intent extras
        book = (Book) Parcels.unwrap(getIntent().getParcelableExtra(Book.class.getSimpleName()));
        // Use book object to populate data into views
        tvTitle.setText(book.getTitle());
        tvAuthor.setText(book.getAuthor());
        toolbar.setTitle(book.getTitle() + " by " + book.getAuthor());
        Glide.with(this)
                .load(book.getCoverUrl())
                .placeholder(R.drawable.book_background)
                .error(R.drawable.book_background)
                .into(ivBookCover);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_book_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
