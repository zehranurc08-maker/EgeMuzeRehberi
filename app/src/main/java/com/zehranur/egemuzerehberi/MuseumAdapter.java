package com.zehranur.egemuzerehberi;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MuseumAdapter extends RecyclerView.Adapter<MuseumAdapter.MuseumViewHolder> {

    private List<Museum> museumList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Museum museum);
    }

    public MuseumAdapter(List<Museum> museumList, OnItemClickListener listener) {
        this.museumList = museumList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MuseumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layoutId = parent.getContext().getResources().getIdentifier("item_museum", "layout", parent.getContext().getPackageName());
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return new MuseumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MuseumViewHolder holder, int position) {
        Museum museum = museumList.get(position);

        if (holder.textViewName != null) holder.textViewName.setText(museum.getName());
        if (holder.textViewLocation != null) holder.textViewLocation.setText(museum.getLocation());
        if (holder.imageView != null) holder.imageView.setImageResource(museum.getImageResId());

        // 1. Kısa basıldığında detay sayfasına
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(museum);
                }
            }
        });


        // Kartın tıklanabilir ve uzun basılabilir olduğunu Java'dan kesinleştiriyoruz
        holder.itemView.setClickable(true);
        holder.itemView.setLongClickable(true);

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // Dinamik olarak tam o saniyede basılan satır üzerinde menüyü zorla oluşturuyoruz
                v.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
                    @Override
                    public void onCreateContextMenu(ContextMenu menu, View menuV, ContextMenu.ContextMenuInfo menuInfo) {
                        menu.setHeaderTitle("İşlem Seçin");
                        menu.add(0, 1, 0, "Favorilere Ekle");
                        menu.add(0, 2, 0, "Müzeyi Paylaş");
                    }
                });


                v.showContextMenu();

                return true;
            }
        });
    }
    @Override
    public int getItemCount() {
        return museumList.size();
    }

    public void filterList(List<Museum> filteredList) {
        this.museumList = filteredList;
        notifyDataSetChanged();
    }

    public static class MuseumViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewLocation;
        ImageView imageView;

        public MuseumViewHolder(@NonNull View itemView) {
            super(itemView);

            if (itemView instanceof ViewGroup) {
                ViewGroup cardView = (ViewGroup) itemView;
                if (cardView.getChildCount() > 0 && cardView.getChildAt(0) instanceof ViewGroup) {
                    ViewGroup mainLayout = (ViewGroup) cardView.getChildAt(0);

                    for (int i = 0; i < mainLayout.getChildCount(); i++) {
                        View child = mainLayout.getChildAt(i);

                        if (child instanceof ImageView) {
                            imageView = (ImageView) child;
                        } else if (child instanceof ViewGroup) {
                            ViewGroup textLayout = (ViewGroup) child;
                            for (int j = 0; j < textLayout.getChildCount(); j++) {
                                View textChild = textLayout.getChildAt(j);
                                if (textChild instanceof TextView) {
                                    if (textViewName == null) {
                                        textViewName = (TextView) textChild;
                                    } else if (textViewLocation == null) {
                                        textViewLocation = (TextView) textChild;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}