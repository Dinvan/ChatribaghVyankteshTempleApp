package adapter;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ank.chatribaghvyankteshtempleapp.FullScreenGalleryImageActivity;
import com.ank.chatribaghvyankteshtempleapp.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.utils.MemoryCacheUtils;

import java.io.IOException;
import java.util.List;

import models.GalleryItemModel;

/**
 * Created by Ankur on 16/07/2016.
 */
public class GalleryImageAdapter extends RecyclerView.Adapter<GalleryImageAdapter.MyViewHolder> {


    private Context mContext;
    private List<GalleryItemModel> galleryItemModels;

    public GalleryImageAdapter(Context mContext, List<GalleryItemModel> galleryItemModels) {
        this.mContext = mContext;
        this.galleryItemModels = galleryItemModels;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgItem,imgDots;

        public MyViewHolder(View view) {
            super(view);
            imgItem = (ImageView) view.findViewById(R.id.imgItem);
            imgDots = (ImageView) view.findViewById(R.id.imgDots);


        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        downloadProfileImages(galleryItemModels.get(position).getImagepath(),holder.imgItem);
        holder.imgItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, FullScreenGalleryImageActivity.class);
                intent.putExtra("imagePath",galleryItemModels.get(position).getImagepath());
                mContext.startActivity(intent);

            }
        });
        holder.imgDots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   Toast.makeText(mContext,"images",Toast.LENGTH_LONG).show();
                showPopupMenu(v,position);
            }
        });


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gallery_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return galleryItemModels.size();
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view,int position) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_gallery_item, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener(position));
        popup.show();
    }

    public static void setImageAsWallPaper(String imagePath,final Context context)
    {
        // TODO Auto-generated method stub
        final WallpaperManager myWallpaperManager = WallpaperManager.getInstance(context);
            ImageLoader imageLoader = ImageLoader.getInstance();
            imageLoader.loadImage(imagePath, new SimpleImageLoadingListener() {
                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    // Do whatever you want with Bitmap
                    try {
                        myWallpaperManager.setBitmap(loadedImage);
                        Toast.makeText(context, "Wallpaper set successfully", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

    }
    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        int position;
        public MyMenuItemClickListener(int position) {
            this.position=position;
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.share_image:
                    Toast.makeText(mContext, "", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.set_as_wallpaper:
                    setImageAsWallPaper(galleryItemModels.get(position).getImagepath(),mContext);

                    return true;
                default:
            }
            return false;
        }
    }



    public static void downloadProfileImages(String url,ImageView imageView) {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .considerExifParams(true)
                .displayer(new FadeInBitmapDisplayer(300))
                .build();
        ImageLoader.getInstance().displayImage(url, imageView, options, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                Log.e("Started", "onLoadingStarted" + imageUri);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                Log.e("Fail", "onLoadingFailed" + imageUri);

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                Log.e("Download Complete", "" + imageUri);

            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
            }
        });
    }


}


