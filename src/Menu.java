
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author LapTop
 */
public class Menu {

    Scanner sc = new Scanner(System.in);
    SinhVien[] svList = new SinhVien[100];
    int chon, i;
    int n = 0;
    int total = 0;

    public void showMenu() {

        while (true) {
            try {
                System.out.println("----------Menu----------");
                System.out.println("1.Nhap danh sach sinh vien.");
                System.out.println("2.Xuat danh sach sinh vien.");
                System.out.println("3.Tim sinh vien theo khoang diem.");
                System.out.println("4.Tim sinh vien theo hoc luc.");
                System.out.println("5.Tim sinh vien theo ma so.");
                System.out.println("6.Sap xep sinh vien theo diem");
                System.out.println("7.Xuat nam hoc vien co diem cao nhat");
                System.out.println("8.Tinh diem trung binh cua lop.");
                System.out.println("9.Xuat DSSV co diem TB tren diem Tb.");
                System.out.println("10.Tong hop sinh vien theo học luc.");
                System.out.println("0.exit");
                System.out.println("-------Moi ban chon chuc nang-------");

                chon = sc.nextInt();
                switch (chon) {
                    case 1:
                        System.out.println("1.Nhap danh sach sinh vien.");
                        nhap();
                        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                        break;
                    case 2:
                        System.out.println("2.Xuat danh sach sinh vien.");
                        xuat();
                        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                        break;
                    case 3:
                        System.out.println("3.Tim sinh vien theo khoang diem");
                        timTKD();
                        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                        break;
                    case 4:
                        System.out.println("4.Tim sinh vien theo hoc luc");
                        timSVTHL();
                        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                        break;
                    case 5:
                        System.out.println("5.Tim sinh vien theo ma so");
                        timMS();
                        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                        break;
                    case 6:
                        System.out.println("6.Sap xep sinh vien theo diem");
                        sxTD();
                        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                        break;
                    case 7:
                        System.out.println("7.Xuat nam hoc vien co diem cao nhat");
                        Top5();
                        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                        break;
                    case 8:
                        System.out.println("8.Tinh diem trung binh cua lop");
                        tinhTB();
                        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                        break;
                    case 9:
                        System.out.println("9.Xuat DSSV co diem TB tren diem Tb ");
                        svTrenTB();
                        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                        break;
                    case 10:
                        System.out.println("10.Tong hop sinh vien theo học luc");
                        tongket();
                        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Chon 0 den 10");
                        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                }
                if (chon == 0) {

                    System.out.print("Are you sure? yes/no: ");
                    char ch = (char) System.in.read();
                    if (ch == 'y' | ch == 'Y') {
                        System.out.println("Da thoat.......");
                        System.exit(0);
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Loi yeu cau nhap so");
                sc = new Scanner(System.in);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void nhap() {
        System.out.print("Số lượng học viên cần nhập là:  ");
        n = sc.nextInt();
        for (i = 0; i < n; i++) {
            svList[i] = new SinhVien();
            svList[i].addsv();
            total++;
            if (i < n - 1) {
                System.out.print("Tiếp tục ? y/n : ");
            } else {
                break;
            }
            if (sc.next().equalsIgnoreCase("n")) {
                break;
            }
        }

    }

    public void xuat() {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.printf("\t%-8s %-25s %-5s %-25s %-15s\n ", "Mã", "Họ Và Tên", "Điểm", "Email", "Học Lực");
        System.out.println("---------------------------------------------------------------------------------");
        for (i = 0; i < total; i++) {
            svList[i].outsv();

        }
    }

    public void timTKD() {
        System.out.println("Tìm trong khoảng từ điểm: ");
        int min = sc.nextInt();
        System.out.println("Đến điểm: ");
        int max = sc.nextInt();
        System.out.println("---------------------------------------------------------------------------------");
        System.out.printf("\t%-8s %-25s %-5s %-25s %-15s\n ", "Mã", "Họ Và Tên", "Điểm", "Email", "Học Lực");
        System.out.println("---------------------------------------------------------------------------------");
        for (int i = 0; i < total; i++) {
            if (min <= svList[i].getdiem() && svList[i].getdiem() <= max) {
                svList[i].outsv();
            }
        }
    }

    public void timSVTHL() {
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("Mời bạn chọn học lực muốn tìm: ");
        System.out.println("1. Xuất Sắc");
        System.out.println("2. Giỏi ");
        System.out.println("3. Khá");
        System.out.println("4. Trung Bình");
        System.out.println("5. Yếu");
        System.out.println("6. Kém");
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println("Mời bạn chọn học lực muốn tìm: ");
        int chon = sc.nextInt();

        switch (chon) {
            case 1:
                System.out.println("---------------------------------------------------------------------------------");
                System.out.printf("\t%-8s %-25s %-5s %-25s %-15s\n ", "Mã", "Họ Và Tên", "Điểm", "Email", "Học Lực");
                System.out.println("---------------------------------------------------------------------------------");

                for (i = 0; i < total; i++) {

                    if (svList[i].gethocLuc().equalsIgnoreCase("Xuất Sắc")) {

                        svList[i].outsv();

                    }

                }
                break;
            case 2:
                System.out.println("---------------------------------------------------------------------------------");
                System.out.printf("\t%-8s %-25s %-5s %-25s %-15s\n ", "Mã", "Họ Và Tên", "Điểm", "Email", "Học Lực");
                System.out.println("---------------------------------------------------------------------------------");
                for (i = 0; i < total; i++) {
                    if (svList[i].gethocLuc().equalsIgnoreCase("Giỏi")) {

                        svList[i].outsv();

                    }
                }
                break;
            case 3:
                System.out.println("---------------------------------------------------------------------------------");
                System.out.printf("\t%-8s %-25s %-5s %-25s %-15s\n ", "Mã", "Họ Và Tên", "Điểm", "Email", "Học Lực");
                System.out.println("---------------------------------------------------------------------------------");
                for (i = 0; i < total; i++) {
                    if (svList[i].gethocLuc().equalsIgnoreCase("Khá")) {

                        svList[i].outsv();

                    }
                }
                break;
            case 4:
                System.out.println("---------------------------------------------------------------------------------");
                System.out.printf("\t%-8s %-25s %-5s %-25s %-15s\n ", "Mã", "Họ Và Tên", "Điểm", "Email", "Học Lực");
                System.out.println("---------------------------------------------------------------------------------");
                for (int i = 0; i < total; i++) {
                    if (svList[i].gethocLuc().equalsIgnoreCase("Trung Bình")) {

                        svList[i].outsv();

                    }
                }
                break;
            case 5:
                System.out.println("---------------------------------------------------------------------------------");
                System.out.printf("\t%-8s %-25s %-5s %-25s %-15s\n ", "Mã", "Họ Và Tên", "Điểm", "Email", "Học Lực");
                System.out.println("---------------------------------------------------------------------------------");
                for (int i = 0; i < total; i++) {
                    if (svList[i].gethocLuc().equalsIgnoreCase("Yếu")) {

                        svList[i].outsv();

                    }

                }
                break;
            case 6:
                System.out.println("---------------------------------------------------------------------------------");
                System.out.printf("\t%-8s %-25s %-5s %-25s %-15s\n ", "Mã", "Họ Và Tên", "Điểm", "Email", "Học Lực");
                System.out.println("---------------------------------------------------------------------------------");

                for (int i = 0; i < total; i++) {
                    if (svList[i].gethocLuc().equalsIgnoreCase("Kém")) {

                        svList[i].outsv();

                    }
                }
                break;
            default:
                System.out.println("Vui lòng nhập từ 1-6");
                break;
        }
    }

    public void timMS() {
        System.out.println("Mời bạn nhập mã số học sinh cần tìm: ");
        sc = new Scanner(System.in);
        String ma;

        System.out.println("---------------------------------------------------------------------------------");
        System.out.printf("\t%-8s %-25s %-5s %-25s %-15s\n ", "Mã", "Họ Và Tên", "Điểm", "Email", "Học Lực");
        System.out.println("---------------------------------------------------------------------------------");

        ma = sc.next();
        int dem = 0;
        for (i = 0; i < total; i++) {
            if (svList[i].getmaSv().equalsIgnoreCase(ma)) {
                svList[i].outsv();

            }
            dem++;
        }
        if (dem == 0) {
            System.out.println("Không tìm thấy");
        }
    }

    public void sxTD() {
        System.out.println("Sắp xếp học viên theo điểm: ");
        for (i = 0; i < total - 1; i++) {
            for (int j = i + 1; j < total; j++) {
                if (svList[i].getdiem() < svList[j].getdiem()) {
                    SinhVien sv1 = new SinhVien();
                    sv1 = svList[i];
                    svList[i] = svList[j];
                    svList[j] = sv1;
                }
            }
        }
        System.out.printf("\t%-8s %-20s %-5s %15s %15s\n ", "Mã", "Họ Và Tên", "diem", "email", "Học Lực");

        System.out.println("-------------------------------------------------------------------------------");

        for (i = 0; i < total; i++) {

            svList[i].outsv();

        }
    }

    public void Top5() {

        System.out.println(" \t\t XUẤT TOP 5 SINH VIÊN CAO NHẤT ");
        System.out.printf("\t%-8s %-25s %-5s %-25s %-15s\n ", "Mã", "Họ Và Tên", "Điểm", "Email", "Học Lực");
        System.out.println("---------------------------------------------------------------------------------");

        for (i = 0; i < total - 1; i++) {
            for (int j = i + 1; j < total; j++) {
                if (svList[i].getdiem() < svList[j].getdiem()) {
                    SinhVien sv1 = new SinhVien();

                    sv1 = svList[i];
                    svList[i] = svList[j];
                    svList[j] = sv1;
                }
            }
        }
        if (n < 5) {
            for (i = 0; i < total; i++) {
                svList[i].outsv();
            }
        } else {
            for (i = 0; i < total; i++) {
                System.out.printf("\t%-8s %-25s %-5s %-25s %-15s\n ", "Mã", "Họ Và Tên", "Điểm", "Email", "Học Lực");
                System.out.println("--------------------------------------------------------------------------------");
                svList[i].outsv();
            }
        }
    }

    public void tinhTB() {
        int dem = 0;
        double tong = 0;
        for (i = 0; i < total; i++) {
            tong = (double) (tong + svList[i].getdiem());
            dem++;
        }
        double diemTB = tong / dem;
        System.out.println("Điểm Trung Bình lớp " + diemTB);
    }

    public void svTrenTB() {
        System.out.println("");
        System.out.println(" \t\t Danh Sach học viên có điểm trên trung bình   ");
        System.out.println("");
        System.out.printf("\t%-8s %-25s %-5s %-25s %-15s\n ", "Mã", "Họ Và Tên", "Điểm", "Email", "Học Lực");
        System.out.println("---------------------------------------------------------------------------------");
        for (i = 0; i < total; i++) {
            if (svList[i].getdiem() > 5) {

                svList[i].outsv();
            }
        }
    }

    public void tongket() {
        int Kem = 0, Y = 0, TB = 0, K = 0,
                G = 0, XS = 0;

        for (int i = 0; i < total; i++) {
            String HL = svList[i].gethocLuc();

            if (HL.equalsIgnoreCase("Kém")) {
                Kem++;
            } else if (HL.equalsIgnoreCase("Yếu")) {
                Y++;
            } else if (HL.equalsIgnoreCase("Trung Bình")) {
                TB++;
            } else if (HL.equalsIgnoreCase("Khá")) {
                K++;
            } else if (HL.equalsIgnoreCase("Giỏi")) {
                G++;
            } else if (HL.equalsIgnoreCase("Xuất Sắc")) {
                XS++;
            }
        }

        System.out.println("");
        System.out.println(" \t\t  Tổng Theo Học Lực ");
        System.out.println("");

        System.out.println("Có " + XS + " sinh viên xuất sắc");
        System.out.println("Có " + G + " sinh viên giỏi");
        System.out.println("Có " + K + " sinh viên khá");
        System.out.println("Có " + TB + " sinh viên viên trung bình");
        System.out.println("Có " + Y + " sinh viên yếu");
        System.out.println("Có " + Kem + " sinh viên viên kém");

    }

}
