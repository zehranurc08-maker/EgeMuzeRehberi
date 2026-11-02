package com.zehranur.egemuzerehberi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView; // Eklendi: Görsel için gerekli
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // ÖNCE BİLEŞENLERİ TANIMLIYORUZ
        final TextView txtName = findViewById(R.id.txtDetailName);
        TextView txtDescription = findViewById(R.id.txtDescription);
        ImageView imgMuseumDetail = findViewById(R.id.imgMuseumDetail); // Boş çerçeveyi dolduracak olan görsel bileşeni
        Button btnWebsite = findViewById(R.id.btnWebsite);
        Button btnMap = findViewById(R.id.btnMap);
        RatingBar ratingBar = findViewById(R.id.museumRatingBar);

        // MÜZE BİLGİ HAVUZU (HashMap) - Sıralama hatasını önlemek için yukarı taşındı
        HashMap<String, String> museumInfo = new HashMap<>();

        // İZMİR MÜZELERİ
        museumInfo.put("Efes Müzesi", "Dünyanın en önemli arkeoloji müzelerinden biri olan bu ikonik mekan, Efes Antik Kenti kazılarından çıkarılan eşsiz eserlere ev sahipliği yapmaktadır. Ziyaretçilerin en çok ilgisini çeken eserlerin başında, bereketi simgeleyen dünyaca ünlü Efes Artemis heykelleri gelmektedir. Ayrıca imparator büstleri, antik çağ paraları ve Celsus Kütüphanesi'ne ait nadide parçalar burada sergilenir. Bölgenin binlerce yıllık kültürel gelişimini tek bir çatı altında sunan müze, tarih meraklıları için vazgeçilmez bir duraktır.");

        museumInfo.put("Bergama Müzesi", "UNESCO Dünya Mirası Listesi'nde yer alan antik Bergama şehrinin kalbinde kurulan bu müze, tıp tarihinin ilk büyük merkezi kabul edilen Asklepion buluntularını barındırır. Erken Tunç Çağı'ndan Osmanlı dönemine kadar uzanan geniş bir zaman dilimine ait arkeolojik eserler ziyaretçileri büyülemektedir. Devasa Zeus Sunağı'nın maketi ve akropol kazılarından elde edilen akılalmaz güzellikteki heykeller müzenin en değerli parçalarıdır. Antik dünyanın bilim, sanat ve mimaride ulaştığı en üst seviyeyi gözler önüne seren çok özel bir sergileme alanıdır.");

        museumInfo.put("Agora Ören Yeri", "Antik Smyrna kentinin ticari, adli ve siyasi merkezi olan bu tarihi alan, günümüz İzmir'inin merkezinde yükselen muazzam bir açık hava müzesidir. Roma İmparatorluk dönemine ait devasa su kanalları, kemerli bodrum katları ve mermer sütunlar günümüzde hala ilk günkü ihtişamıyla ayakta durmaktadır. Dünyanın en zengin Grekçe duvar yazısı (grafiti) koleksiyonuna sahip olması burayı küresel çapta eşsiz kılmaktadır. Kadifekale ile Konak arasında köprü görevi gören bu alan, kentin köklü geçmişine ışık tutmaktadır.");

        museumInfo.put("İzmir Arkeoloji Müzesi", "Körfeze nazır konumuyla dikkat çeken müze, Ege Denizi kıyılarında ve çevresindeki antik yerleşimlerde yürütülen kazıların meyvelerini sergilemektedir. Bayraklı (Eski Smyrna), Erythrai, Klaros ve Pitane gibi kadim kentlerden çıkarılan büyüleyici mermer heykeller ve bronz eserler burada yer alır. Müzenin en popüler odalarından birinde, Helenistik döneme ait nadide takılar ve antik sikkeler sıkı güvenlik önlemleriyle sergilenir. Ege'nin denizci kültürünü ve ticaret ağlarını anlamak isteyen her araştırmacı için bir başvuru noktasıdır.");

        museumInfo.put("Çeşme Kalesi Müzesi", "İkinci Beyazıt döneminde inşa edilen tarihi Çeşme Kalesi'nin büyüleyici atmosferinde yer alan bu müze, hem savunma mimarisi hem de sergilenen eserlerle çift yönlü bir deneyim sunar. Müze salonlarında Çeşme bölgesi ve Erythrai antik kentinden çıkarılan pişmiş toprak figürler, amforalar ve sikkeler sergilenmektedir. Ayrıca 1770 yılındaki meşhur Osmanlı-Rus Deniz Savaşı'na ait batıklardan çıkarılan askeri malzemeler ve haritalar da büyük ilgi çekmektedir. Kalenin burçlarına çıktığınızda sizi karşılayan eşsiz sakız adası manzarası ise müze gezisini unutulmaz kılar.");

        // MUĞLA MÜZELERİ
        museumInfo.put("Bodrum Sualtı Arkeoloji", "Tarihi Bodrum Kalesi'nin görkemli surları içinde yer alan bu dünyaca ünlü müze, alanında küresel çapta en prestijli merkezlerin başında gelir. Akdeniz'in derinliklerinden büyük bir titizlikle çıkarılan ve dünyanın en eski batık gemi kalıntıları olarak kabul edilen Uluburun Batığı burada sergilenmektedir. Doğu Akdeniz ticaretini aydınlatan altın broşlar, amforalar ve cam külçeler müzenin paha biçilemez koleksiyonunu oluşturur. Hem şövalyelerin tarihi kalesini gezme hem de sualtı dünyasının gizemli tarihine tanıklık etme fırsatı sunan eşsiz bir alandır.");

        museumInfo.put("Knidos Antik Kenti", "Ege ile Akdeniz'in kesiştiği Datça Yarımadası'nın en uç noktasında kurulu olan bu açık hava müzesi, antik çağın en önemli bilim ve sanat merkezlerinden biridir. Astronomi uzmanı Eudoxus ve ünlü heykeltıraş Praxiteles'in yaşadığı bu kent, zamanında Afrodit Heykeli ile dünyaca ün kazanmıştır. Denizciler için korunaklı iki adet antik limanı, devasa tiyatrosu ve güneş saati hala net bir şekilde görülebilmektedir. Hem doğanın büyüleyici maviliğini hem de mermer sütunların binlerce yıllık asaletini bir arada sunan büyüleyici bir atmosfere sahiptir.");

        museumInfo.put("Zeki Müren Sanat Müzesi", "Türkiye'nin 'Sanat Güneşi' olarak kalplerde taht kuran Zeki Müren'in ömrünün son yıllarını geçirdiği Bodrum'daki evi, günümüzde anılarını yaşatan bir müzeye dönüştürülmüştür. İki katlı bu şirin evde sanatçının kendi tasarladığı sahne kostümleri, aldığı ödüller, el yazısı notları ve kişisel eşyaları sergilenmektedir. Bahçesinde ise ünlü sanatçının uzun yıllar kullandığı ikonik otomobili ziyaretçileri karşılar. Müzenin odalarında yankılanan taş plak sesleri, ziyaretçileri nostaljik ve duygu dolu bir zaman yolculuğuna çıkarır.");

        museumInfo.put("Marmaris Kalesi Müzesi", "Kanuni Sultan Süleyman'ın Rodos seferi öncesinde yeniden inşa ettirdiği bu tarihi kale, Marmaris Limanı'na hakim bir tepede tüm heybetiyle yükselmektedir. Kale içerisindeki arkeoloji salonlarında Marmaris, Knidos ve Burgaz bölgelerinden toplanan Helenistik ve Roma dönemlerine ait buluntular yer alır. Etnografya kısmında ise Osmanlı dönemine ait mutfak eşyaları, geleneksel giysiler ve dokumalar sergilenmektedir. Kalenin begonvillerle süslü avlusu ve burçlarından izlenen Marmaris körfezi manzarası fotoğraf tutkunları için harika bir fon oluşturur.");

        // AYDIN MÜZELERİ
        museumInfo.put("Aphrodisias Müzesi", "Aşk ve güzellik tanrıçası Afrodit'e adanmış olan bu muazzam kent, antik çağın en prestijli heykeltıraşlık okuluna ev sahipliği yapmasıyla bilinir. Kazılardan çıkarılan ve kusursuz işçilikleriyle göz kamaştıran mermer kabartmalar ile devasa tanrı heykelleri müze salonlarında sergilenmektedir. Türkiye'nin en iyi korunmuş antik stadyumu ve görkemli Sebastion tapınağı ören yerinin en çarpıcı yapıları arasındadır. UNESCO Dünya Mirası Listesi'nde yer alan bu saklı cennet, mermere can veren sanatçıların öyküsünü anlatır.");

        museumInfo.put("Milet Müzesi", "Pozitif bilimlerin, felsefenin ve rasyonalizmin başkenti kabul edilen Milet Antik Kenti'nin hemen yanı başında modern bir tasarımla inşa edilmiş bir müzedir. Thales, Anaximandros ve Hekataios gibi tarihe yön veren düşünürlerin yürüdüğü topraklardan çıkan felsefi ve bilimsel izler burada sergilenir. Müze koleksiyonunda Didim Apollon Tapınağı'ndan gelen kehanet objeleri, mermer büstler ve günlük kullanım eşyaları yer alır. Antik çağ insanının sosyal hayatını, inanç sistemlerini ve entelektüel derinliğini anlamak adına muhteşem bir birikim sunar.");

        museumInfo.put("Apollon Tapınağı", "Didim ilçesinde yer alan bu devasa yapı, antik dünyanın en büyük ve en önemli kehanet merkezlerinden biri olarak kabul edilmektedir. Heybetli sütunları, göz alıcı mermer işçiliği ve mitolojik hikayelere konu olan ünlü Medusa kabartması ile görenleri ilk bakışta büyülemektedir. Antik çağda insanlar geleceğe dair sorularının yanıtlarını aramak için kilometrelerce uzaktan bu kutsal alana gelmişlerdir. Günümüzde tam anlamıyla bitirilememiş bir başyapıt olarak kabul edilen tapınak, mimari dehasıyla mühendislik harikasıdır.");

        // DENİZLİ & MANİSA MÜZELERİ
        museumInfo.put("Hierapolis Arkeoloji", "Pamukkale'nin bembeyaz travertenlerinin hemen yanı başında yer alan bu müze, antik dönemin şifalı termal kenti Hierapolis'in görkemini yansıtır. Büyük bir Roma hamam kompleksinin restore edilmesiyle oluşturulan müze salonları, devasa lahitler ve kabartmalarla doludur. Lahitler Lahiti adı verilen odada Roma dönemine ait ölü gömme gelenekleri ve sanatsal mezar mimarisi sergilenir. Hem doğa harikası travertenleri gezip şifalı suların tadını çıkarma hem de antik Roma kültürünü derinlemesine soluma imkanı sunan büyüleyici bir yerdir.");

        museumInfo.put("Laodikeia Antik Kenti", "Hristiyanlık dünyası için hayati öneme sahip olan İncil'de adı geçen 7 kutsal kiliseden birini barındıran bu devasa kent, Denizli'nin en büyük tarihi hazinesidir. Geniş mermer caddeleri, iki adet devasa antik tiyatrosu ve restore edilen kutsal kilise yapısıyla göz alıcı bir planlamaya sahiptir. Antik çağın en önemli tekstil ve ticaret merkezlerinden biri olan kentte, gelişmiş su dağıtım şebekeleri ve dev çeşmeler dikkat çeker. Yürütülen titiz kazı çalışmaları sayesinde adeta yeniden ayağa kalkan bu kent, ziyaretçilerine gerçek bir Roma şehrinde yürüme hissi verir.");

        museumInfo.put("Sardes Antik Kenti", "Manisa'nın Salihli ilçesinde yer alan bu kadim kent, tarihte paranın ilk basıldığı yer olan efsanevi Lidya Krallığı'nın görkemli başkentidir. Dünyanın en büyük antik sinagoglarından birine ev sahipliği yapması, kentin inanç turizmindeki küresel önemini açıkça ortaya koymaktadır. Ayrıca devasa sütunlarıyla göz kamaştıran Artemis Tapınağı ve restore edilmiş olan ihtişamlı Roma Gymnasium yapısı kentin simgeleridir. Tarihi Kral Yolu'nun başlangıç noktası olan bu alan, altın madenleriyle ünlü Pactolus çayının kıyısında tarih yazmıştır.");


        // 3. VERİLERİ ANADROID STUDIO EVRENİNDEN ALIP EKRANA YAZIYORUZ
        String name = getIntent().getStringExtra("MUSEUM_NAME");
        int imageResId = getIntent().getIntExtra("MUSEUM_IMAGE", R.drawable.ic_launcher_background);

        // Değerleri bileşenlere set ediyoruz
        if (name != null) {
            txtName.setText(name);
        }

        // Resmi ekrana oturtan satır:
        if (imgMuseumDetail != null) {
            imgMuseumDetail.setImageResource(imageResId);
        }


        // YOL TARİFİ BUTONU (Haritaları Açar)
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String museumName = txtName.getText().toString();
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(museumName));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/?q=" + Uri.encode(museumName))));
                }
            }
        });

        // WEB SİTESİ BUTONU (WebView Sayfasına Geçer)
        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, WebActivity.class);
                intent.putExtra("url", "https://muze.gov.tr");
                startActivity(intent);
            }
        });

        // AÇIKLAMAYI SET ETME
        if (name != null) {
            String description = museumInfo.get(name);
            if (description != null) {
                txtDescription.setText(description);
            } else {
                txtDescription.setText(name + ", Ege Bölgesi'nin zengin tarihini yansıtan son derece değerli ve popüler bir müzedir.");
            }
        }
    }
}