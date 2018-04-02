package network.dhammakaya.testbase3.Bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Delux on 3/24/2018.
 */

public class ProductBean implements Parcelable {

    /**
     * id : 1
     * id_product : P001
     * name : iphone x
     * detail :
     * price : 40,500
     * img_url : http://booncalendar.dhammakaya.network/images/iphone-x-select-2017.png
     */

    private String id;
    private String id_product;
    private String name;
    private String detail;
    private String price;
    private String img_url;

    public static final String BASE_URL = "http://booncalendar.dhammakaya.network/connect/";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_product() {
        return id_product;
    }

    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.id_product);
        dest.writeString(this.name);
        dest.writeString(this.detail);
        dest.writeString(this.price);
        dest.writeString(this.img_url);
    }

    public ProductBean() {
    }

    protected ProductBean(Parcel in) {
        this.id = in.readString();
        this.id_product = in.readString();
        this.name = in.readString();
        this.detail = in.readString();
        this.price = in.readString();
        this.img_url = in.readString();
    }

    public static final Parcelable.Creator<ProductBean> CREATOR = new Parcelable.Creator<ProductBean>() {
        @Override
        public ProductBean createFromParcel(Parcel source) {
            return new ProductBean(source);
        }

        @Override
        public ProductBean[] newArray(int size) {
            return new ProductBean[size];
        }
    };
}
