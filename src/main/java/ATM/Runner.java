package ATM;



public class Runner extends Depo {


    public static void main(String[] args) {

        anaMenu();
    }

    public static void anaMenu() {

        System.out.println("ATM'ye Hoşgeldiniz...\nLütfen Kart No Giriniz.");
        girilenKartNo = input.nextLine().replace(" ", "");
        System.out.println("Şifrenizi Giriniz");
        girilenSifre = input.next();

        if (gecerliKartNo.equals(girilenKartNo) && gecerliSifre.equals(girilenSifre)) {
            menum();
        } else {
            System.out.println("Yanlis Giris Yaptiniz. Lütfen tekrar deneyiniz.");
            anaMenu();
        }
    }

    private static void menum() {
        System.out.println("Lütfen yapmak istediğiniz işlemi giriniz\n1-->Bakiye Sorgulama\n2-->Para Yatırma\n" +
                "3-->Para Cekme\n4-->Para Gonderme\n5-->Sifre Degistirme\n6-->Cikis");

        secim = input.next();

        switch (secim) {
            case "1":
                bakiyeSorgulama();
            case "2":
                paraYatirma();
            case "3":
                paraCekme();
            case "4":
                paraGonderme();
            case "5":
                SifreDegistirme();
            case "6":
                System.exit(0);
        }

    }

    private static void SifreDegistirme() {
        System.out.println("Lütfen önceki şifrenizi giriniz.");
        girilenSifre = input.next();
        if (gecerliSifre.equals(girilenSifre)) {
            System.out.println("Lütfen yeni şifrenizi giriniz.");
            gecerliSifre = input.next();
            System.out.println("Şifreniz başarıyla değiştirilmiştir.");
            menum();
        } else {
            System.out.println("Yanlis Sifre Girdiniz.\nŞimdi ne yapmak istersiniz?\n1-->Şifre Değiştir\\n2-->Menü\" ");
            secim = input.next();
            switch (secim) {
                case "1":
                    SifreDegistirme();
                case "2":
                    menum();
            }
        }
    }

    private static void paraGonderme() {
        System.out.println("Lütfen para göndermek istediğiniz tutarı giriniz.");
        gonderilenPara = input.nextInt();
        if (gonderilenPara > bakiye) {
            System.out.println("Geçerli bir miktar giriniz.");
            paraGonderme();
        }
        System.out.println("Lütfen para göndermek istediğiniz IBAN bilgisini giriniz.");
        girilenIBAN = input.next();
        if (!girilenIBAN.startsWith("TR") || girilenIBAN.length() != 26) {
            System.out.println("Geçerli bir IBAN giriniz.");
            paraGonderme();
        } else {

            System.out.println("Para gönderdiğiniz tutar = " + gonderilenPara + "USD");
            bakiye -= gonderilenPara;
            System.out.println("Kalan bakiyeniz = " + bakiye + "USD \nŞimdi ne yapmak istersiniz?\n1-->Para Gonder\n2-->Menü");
            secim = input.next();
            switch (secim) {
                case "1":
                    paraGonderme();
                case "2":
                    menum();
                default:
                    System.out.println("Yanlış giriş.");
                    menum();
            }

        }
    }

    private static void paraCekme() {
        System.out.println("Lütfen çekmek istediğiniz tutarı giriniz.");
        cekilenPara = input.nextInt();
        if (cekilenPara > bakiye) {
            System.out.println("Geçerli bir miktar giriniz.");
            paraCekme();
        } else {
            System.out.println("Çektiğiniz tutar = " + cekilenPara + "USD");
            bakiye -= cekilenPara;
            System.out.println("Kalan bakiyeniz = " + bakiye + "USD \nŞimdi ne yapmak istersiniz?\n1-->Para Cek\n2-->Menü");
            secim = input.next();
            switch (secim) {
                case "1":
                    paraCekme();
                case "2":
                    menum();
                default:
                    System.out.println("Yanlış giriş.");
                    menum();
            }

        }

    }

    private static void paraYatirma() {
        System.out.println("Ne kadar para yatıracaksınız?");
        yatirilanPara = input.nextInt();

        if (yatirilanPara % 10 != 0) {
            System.out.println("Lütfen 10 ve 10'un katları olacak şekilde bir miktar giriniz");
        } else {
            bakiye += yatirilanPara;
            System.out.println("Güncel bakiyeniz : " + bakiye + " USD" + "\nŞimdi ne yapmak istersiniz? \n1-->Para Yatır\n2-->Menü ");
            secim = input.next();
            switch (secim) {
                case "1":
                    paraYatirma();
                case "2":
                    menum();
                default:
                    System.out.println("Yanlış giriş.");
                    menum();
            }
        }


    }

    private static void bakiyeSorgulama() {
        System.out.println("Bakiyeniz : " + bakiye);
        menum();
    }
}
