
import java.util.Scanner;



public class SinhVien {

    Scanner sc = new Scanner(System.in);
    private String hoTen, email, hocLuc, maSV;
    private double diem;

  
     public SinhVien() {
        this.maSV = "";
        this.hoTen = "";
        this.diem = 0;
        this.email ="" ;
        this.hocLuc ="" ;

    }
    public SinhVien(String hoTen, String email, String hocLuc, String maSv, double diem) {
        this.maSV = maSv;
        this.hoTen = hoTen;
        this.diem = diem;
        this.email = email;
        this.hocLuc = hocLuc;

    }



    public void setmaSv(String maSv){
        this.maSV = maSv;
    
};  
    public String getmaSv(){
    return this.hoTen;
    }

    public void sethoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String gethoTen() {
        return this.hoTen;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setdiem(double diem) {
        this.diem = diem;
    }

    public double getdiem() {
        return this.diem;
    }

    public void addsv() {
        System.out.print("Mã số sinh viên: ");
        maSV = sc.nextLine();

        System.out.print("Tên sinh viên: ");
        hoTen = sc.nextLine();

        do {
            System.out.print("Điểm: ");
            diem = sc.nextDouble();
        } while (diem < 0 || diem > 10);

        System.out.print("Email: ");
        sc = new Scanner(System.in);
        email = sc.nextLine();

        System.out.println("----------------------");
    }

    public String gethocLuc() {
        if (diem < 3) {
            hocLuc = "Kém";

        } else if (diem < 5) {
            hocLuc = "Yếu";

        } else if (diem < 6.5) {
            hocLuc = "Trung Bình";

        } else if (diem < 7.5) {
            hocLuc = "Khá";

        } else if (diem < 9) {
            hocLuc = "Giỏi";

        } else if (diem <= 10) {
            hocLuc = "Xuất Sắc";

        }
        return hocLuc;
    }

    public void outsv() {

        System.out.printf("\t%-8s %-25s %-5s %-25s %-15s\n ", maSV, hoTen, diem, email, gethocLuc());
    }

}
