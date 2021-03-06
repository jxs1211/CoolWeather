package xianjie.shen.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class FoodTypeListViewAdapter extends RecyclerView.Adapter<MyViewHolder>
{
  private Context mContext;
  protected List<?> mDatas;
  private LayoutInflater mInflater;
  private int mLayoutId;
  private OnItemClickListener mOnItemClickListener;

  public FoodTypeListViewAdapter(Context paramContext, List<?> paramList, int paramInt)
  {
    this.mContext = paramContext;
    this.mDatas = paramList;
    this.mLayoutId = paramInt;
    this.mInflater = LayoutInflater.from(paramContext);
  }

  private DistrictFragmentItemBean generateItemBean(int paramInt, String paramString)
  {
    return new DistrictFragmentItemBean(paramInt, paramString);
  }

  private void setUpItemClickListener(final MyViewHolder paramMyViewHolder)
  {
    if (this.mOnItemClickListener != null)
    {
      paramMyViewHolder.itemView.setOnClickListener(new OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          int i = paramMyViewHolder.getLayoutPosition();
          FoodTypeListViewAdapter.this.mOnItemClickListener.onItemClickListener(paramAnonymousView, i, paramMyViewHolder);
        }
      });
      paramMyViewHolder.itemView.setOnLongClickListener(new OnLongClickListener()
      {
        public boolean onLongClick(View paramAnonymousView)
        {
          int i = paramMyViewHolder.getLayoutPosition();
          FoodTypeListViewAdapter.this.mOnItemClickListener.onItemLongClickListener(paramAnonymousView, i, paramMyViewHolder);
          return false;
        }
      });
    }
  }

  private void setUpItemClickListener(final MyViewHolder paramMyViewHolder, final int paramInt)
  {
    if (this.mOnItemClickListener != null)
    {
      paramMyViewHolder.itemView.setOnClickListener(new OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          FoodTypeListViewAdapter.this.mOnItemClickListener.onItemClickListener(paramAnonymousView, paramInt, paramMyViewHolder);
        }
      });
      paramMyViewHolder.itemView.setOnLongClickListener(new OnLongClickListener()
      {
        public boolean onLongClick(View paramAnonymousView)
        {
          FoodTypeListViewAdapter.this.mOnItemClickListener.onItemLongClickListener(paramAnonymousView, paramInt, paramMyViewHolder);
          return false;
        }
      });
    }
  }

  public void addItem(int paramInt)
  {
    notifyItemInserted(paramInt);
  }

  public void deleteItem(int paramInt)
  {
    this.mDatas.remove(paramInt);
    notifyItemRemoved(paramInt);
  }

  public int getItemCount()
  {
    return this.mDatas.size();
  }

  public void onBindViewHolder(MyViewHolder paramMyViewHolder, int paramInt)
  {
    paramMyViewHolder.ivImg.setImageResource(((DistrictFragmentItemBean)this.mDatas.get(paramInt)).getImgId());
    paramMyViewHolder.tvName.setText(((DistrictFragmentItemBean)this.mDatas.get(paramInt)).getName());
    setUpItemClickListener(paramMyViewHolder);
  }

  public MyViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new MyViewHolder(this.mInflater.inflate(this.mLayoutId, paramViewGroup, false));
  }

  public void setOnItemCLickListener(OnItemClickListener paramOnItemClickListener)
  {
    this.mOnItemClickListener = paramOnItemClickListener;
  }

  class MyViewHolder extends RecyclerView.ViewHolder
  {
    ImageView iv;
    TextView tv;

    public MyViewHolder(View itemView)
    {
      super(itemView);
      this.iv = ((ImageView)itemView.findViewById(2131361876));
      this.tv = ((TextView)itemView.findViewById(2131361879));
    }
  }

  public static abstract interface OnItemClickListener
  {
    public abstract void onItemClickListener(View paramView, int paramInt, MyViewHolder paramMyViewHolder);

    public abstract void onItemLongClickListener(View paramView, int paramInt, MyViewHolder paramMyViewHolder);
  }
}

/* Location:           E:\tools\apktool\dex2jar-2.0\classes-dex2jar.jar
 * Qualified Name:     shen.xianjie.myapplication.FoodTypeListViewAdapter
 * JD-Core Version:    0.6.2
 */