package odevım;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class odev {
public static final String database_connection_string = "jdb:postgresql://localhost:5432/ogrencıbılgısıstemı";
public static final String database_user_name ="postgres";	
public static final String database_user_password ="1234";
public static Connection baglan= null;
public static Scanner secim=new Scanner(System.in);
public static Statement stmt = null ;
public static String sqlCumlesi = null;
public Connection baglantiOlustur() {
	
	try {
		Class.forName("org.postgresql.Driver");
		baglan = DriverManager.getConnection(database_connection_string,database_user_name,database_user_password);
		if (baglan!=null) {
			System.out.println("veri tabanı baglantısı kuruldu");
		}
	}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			}
		return baglan;
		}
	


 public static void Menu () {
        	 System.out.println("\n\n");
        	 System.out.println("*******************");
        	 System.out.println("veri tabanı");
        	 System.out.println("1-kayıt ekle");
        	 System.out.println("2-kayıt sil");
        	 System.out.println("3-kayıt guncelleme");
        	 System.out.println("4-kayıt ara ");
        	 System.out.println("5-kayıtları listele");
        	 System.out.println("6-cıkıs");
                  	 ///burada menü oluşturdum 
	 public static void kayıtekle() {
		 try {
			 System.out.println("ıd giriniz :");
			 String id = secim.next();
			 System.out.println("adı giriniz:");
			String adı =secim.next();
			System.out.println("soyadı giriniz:");
			String soyadı =secim.next();
			System.out.println("bolumıd giriniz:");
			String bolumıd =secim.next();
			
			sqlCumlesi ="INSERT INTO public.\"ogrntlb\"(id,adı,soyadı,bolumıd)VALUES("+ id +","+"'"+ adı +"'"+","+soyadı+","+"'"+bolumıd+");";
		    stmt = baglan.createStatement();
		    stmt.executeUpdate(sqlCumlesi);
		    stmt.close();
		 }
		 catch (Exception e)
		 {
			 System.err.println(e.getClass().getName()+": "+e.getMessage());
			 System.exit( 0 );
		 }
		 System.out.println("kayıt eklenmiştir");
	 }
	 public static void kayıtsil() {
		 try {
			 System.out.println("ıd giriniz :");
			 String id = secim.next();
			 sqlCumlesi ="INSERT INTO public.\"ogrntlb\"(id,adı,soyadı,bolumıd)VALUES("+ id +","+"'"+ adı +"'"+","+soyadı+","+"'"+bolumıd+");";
			    stmt = baglan.createStatement();
			    stmt.executeUpdate(sqlCumlesi);
			    stmt.close();
		 }
		 
		 catch (Exception ex)
		 {
			 System.out.println(ex.getMessage());
		 }
		 System.out.println("kayıt silinmiştir");
	 }
	 
	 public static void kayıtara() {
		 try {
			 System.out.println("ıd giriniz :");
			 String id = secim.next();
			 
			 sqlCumlesi ="INSERT INTO public.\"ogrntlb\"(id,adı,soyadı,bolumıd)VALUES("+ id +","+"'"+ adı +"'"+","+soyadı+","+"'"+bolumıd+");";
			    stmt = baglan.createStatement();
			    ResultSet Rs = stmt.executeQuery(sqlCumlesi);
			    
			  if(Rs.next())
			  {
				  System.out.println("id"+Rs.getInt(2));
			  }
			  else
			  {
				  System.out.println("kayıt bulunamadı");
			  }
			  Rs.close();
			  stmt.close();
		 }
			  catch (Exception ex)
				 {
					 System.out.println(ex.getMessage());
				 }
				 System.out.println("arama işlemi tamamlandı");
			 
		 }
	 public static void kayıtguncelleme() {
		 try {
			 System.out.println("ıd giriniz :");
			 String id = secim.next();
			 System.out.println("adı giriniz:");
			String adı =secim.next();
			System.out.println("soyadı giriniz:");
			String soyadı =secim.next();
			System.out.println("bolumıd giriniz:");
			String bolumıd =secim.next();
			
			sqlCumlesi ="INSERT INTO public.\"ogrntlb\"(id,adı,soyadı,bolumıd)VALUES("+ id +","+"'"+ adı +"'"+","+soyadı+","+"'"+bolumıd+");";
		    stmt = baglan.createStatement();
		    stmt.executeUpdate(sqlCumlesi);
		    stmt.close();
		 }		
		 catch (Exception ex)
		 {
			 System.out.println(ex.getMessage());
		 }
		 System.out.println("güncelleme işlemi bitti");
	 }
	 public static void kayıtlarılistele() {
		 System.out.println("\n\n");
		 try {
			 PreparedStatement stms = baglan.prepareStatement("SELECT*FROM public.\"ogrntlb\"");
			 ResultSet Rs = stms.executeQuery();
			 System.out.println("tum kayıtlar");
			 while(Rs.next())
				 System.out.println(Rs.getInt(1)+" "+Rs.getString(2));
		 }
	 
	 catch(Exception ex)
	 {
		 System.out.println(ex.getMessage());
	 }
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
  odevım conn = new odevım();
  conn.baglantiOlustur();
  while (1==1) {
	  Menu();
	  String islem="";
	  System.out.println("secim yapınız");
	  islem = secim.next();
	  switch(islem) {
	  
	  case "1":
		  System.out.println("\n\n");
		  kayıtekle();
		  kayıtlarılistele();
		  continue; 
	  case "2":
		  System.out.println("\n\n");
		  kayıtsil();
		  kayıtlarılistele();
		  continue;
	  case "3":
		  System.out.println("\n\n");
		  kayıtguncelleme();
		  kayıtlarılistele();
		  continue; 
	  case "4":
		  System.out.println("\n\n");
		  kayıtara();
		  kayıtlarılistele();
		  continue; 
	  case "5":
		  kayıtlarılistele();
		  continue;
	  case "6":
	  System.out.println("\n\n");
		  System.out.println("çıktınız");
		  System.exit(0);
		  break;
		  default:
			  System.out.println("yanlış bir işlem sectiniz");
			  break;
	  }
	  
  }

	}

}
