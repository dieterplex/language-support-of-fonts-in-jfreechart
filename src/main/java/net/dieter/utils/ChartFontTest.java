package net.dieter.utils;

import java.io.File;
import java.util.Locale;
import java.awt.Font;
import java.awt.image.BufferedImage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.encoders.EncoderUtil;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Usage: <tt>java -cp .:jfreechart.jar:jfreecommon.jar ChartFontTest <i>[fontname ...]</i></tt>
 * <p>
 * In Linux, use "fc-list | sort" to find font names as args. 
 * Notice that if it can't found specified fonts in system, it will depened on System choosing available ones.
 * <p>
 * e.g.
 * <pre>Cuprum:style=Regular
 * cursor.pcf:style=Regular
 * cwTeX 仿宋體,cwTeXFangSong:style=Medium
 * Helvetica Neue:style=細體,Mager,Fein,Light,Ohut,Fin,Leggero,ライト,가는체,Licht,Tynn,Leve,Светлый,细体,Fina
 * <pre>
 * "Cuprum", "cwTeX 仿宋體", "cwTeXFangSong", "Helvetica Neue" are valid font names.
 * <p>
 * <tt>fc-list|sed -e 's/[,:]\+.*$//' -e 's/\(.*\)/"\1"/'|xargs java -cp .:jfreechart-1.0.13.jar:jcommon-1.0.16.jar ChartFontTest</tt>
 * 
 */
public class ChartFontTest {

    static String language =
        "interwiki-ltg			Volūda							Latgaļu \n" +
        "interwiki-af			Taal							Afrikaans \n" +
        "interwiki-als			Sprache							Alemannisch \n" +
        "interwiki-am			ቋንቋ								አማርኛ \n" +
        "interwiki-ar			لغة								العربية \n" +
        "interwiki-an			Luengache						Aragonés \n" +
        "interwiki-arc			ܠܫܢܐ (ܡܡܠܠܐ)					ܐܪܡܝܐ \n" +
        "interwiki-roa-rup		Limba							Armãneashce \n" +
        "interwiki-frp			Lengua							Arpetan \n" +
        "interwiki-ast			Idioma							Asturianu \n" +
        "interwiki-gn			Ñe'ẽ							Avañe'ẽ \n" +
        "interwiki-ay			Aru								Aymar aru \n" +
        "interwiki-az			Dil								Azərbaycanca \n" +
        "interwiki-bm			Kan								Bamanankan \n" +
        "interwiki-bn			ভাষা								বাংলা \n" +
        "interwiki-zh-min-nan	Gí-giân							Bân-lâm-gú \n" +
        "interwiki-map-bms		Basa							Basa Banyumasan \n" +
        "interwiki-ba			Тел (фән)						Башҡортса \n" +
        "interwiki-be			Мова							Беларуская \n" +
        "interwiki-be-x-old		Мова							‪Беларуская (тарашкевіца)‬ \n" +
        "interwiki-bar			Sproch							Boarisch \n" +
        "interwiki-bo			སྐད་རིགས།							བོད་ཡིག \n" +
        "interwiki-bs			Jezik							Bosanski \n" +
        "interwiki-br			Yezh							Brezhoneg \n" +
        "interwiki-bg			Език (лингвистика)				Български \n" +
        "interwiki-ca			Llenguatge						Català \n" +
        "interwiki-cv			Чĕлхе							Чӑвашла \n" +
        "interwiki-ceb			Pinulongan						Cebuano \n" +
        "interwiki-cs			Jazyk (lingvistika)				Česky \n" +
        "interwiki-cy			Iaith							Cymraeg \n" +
        "interwiki-da			Sprog							Dansk \n" +
        "interwiki-pdc			Schprooch						Deitsch \n" +
        "interwiki-de			Sprache							Deutsch \n" +
        "interwiki-dv			ބަސް								ދިވެހިބަސް \n" +
        "interwiki-nv			Saad							Diné bizaad \n" +
        "interwiki-et			Keel (keeleteadus)				Eesti \n" +
        "interwiki-el			Γλώσσα							Ελληνικά \n" +
        "interwiki-eml			Langua							Emiliàn e rumagnòl \n" +
        "interwiki-es			Lenguaje						Español \n" +
        "interwiki-eo			Lingvo							Esperanto \n" +
        "interwiki-eu			Hizkuntza						Euskara \n" +
        "interwiki-fa			زبان							فارسی \n" +
        "interwiki-hif			Bhasa							Fiji Hindi \n" +
        "interwiki-fo			Mál								Føroyskt \n" +
        "interwiki-fr			Langage							Français \n" +
        "interwiki-fy			Taal							Frysk \n" +
        "interwiki-fur			Lengaç							Furlan \n" +
        "interwiki-ga			Teanga (cumarsáid)				Gaeilge \n" +
        "interwiki-gv			Çhengey (çhaghteraght)			Gaelg \n" +
        "interwiki-gd			Cànan							Gàidhlig \n" +
        "interwiki-gl			Linguaxe						Galego \n" +
        "interwiki-gan			語言							贛語 \n" +
        "interwiki-gu			ભાષા								ગુજરાતી \n" +
        "interwiki-hak			Ngî-ngièn						Hak-kâ-fa \n" +
        "interwiki-ko			언어							한국어 \n" +
        "interwiki-hy			Լեզու							Հայերեն \n" +
        "interwiki-hi			भाषा								हिन्दी \n" +
        "interwiki-hr			Jezik							Hrvatski \n" +
        "interwiki-io			Linguo							Ido \n" +
        "interwiki-ilo			Pagsasao						Ilokano \n" +
        "interwiki-id			Bahasa							Bahasa Indonesia \n" +
        "interwiki-ia			Linguage						Interlingua \n" +
        "interwiki-ik			Uqautchit						Iñupiak \n" +
        "interwiki-os			Æвзаг							Ирон \n" +
        "interwiki-xh			Ulwimi							isiXhosa \n" +
        "interwiki-is			Tungumál						Íslenska \n" +
        "interwiki-it			Linguaggio						Italiano \n" +
        "interwiki-he			שפה								עברית \n" +
        "interwiki-jv			Basa							Basa Jawa \n" +
        "interwiki-kl			Oqaatsit						Kalaallisut \n" +
        "interwiki-kn			ಭಾಷೆ								ಕನ್ನಡ \n" +
        "interwiki-krc			Тил								Къарачай-Малкъар \n" +
        "interwiki-ka			ენა (ენათმეცნიერება)			ქართული \n" +
        "interwiki-kk			Тілдін функциялары				Қазақша \n" +
        "interwiki-kw			Yeth							Kernowek \n" +
        "interwiki-ky			Тил								Кыргызча \n" +
        "interwiki-sw			Lugha							Kiswahili \n" +
        "interwiki-koi			Кыв								Перем Коми \n" +
        "interwiki-kv			Кыв								Коми \n" +
        "interwiki-kg			Ndinga							Kongo \n" +
        "interwiki-ht			Lang (pawòl)					Kreyòl ayisyen \n" +
        "interwiki-ku			Ziman							Kurdî \n" +
        "interwiki-lad			Linguaje						Ladino \n" +
        "interwiki-lo			ພາສາ							ລາວ \n" +
        "interwiki-la			Lingua							Latina \n" +
        "interwiki-lv			Valoda							Latviešu \n" +
        "interwiki-lb			Sprooch							Lëtzebuergesch \n" +
        "interwiki-lt			Kalba							Lietuvių \n" +
        "interwiki-li			Taol							Limburgs \n" +
        "interwiki-ln			Lokótá							Lingála \n" +
        "interwiki-jbo			bangu							Lojban \n" +
        "interwiki-hu			Nyelv							Magyar \n" +
        "interwiki-mk			Јазик							Македонски \n" +
        "interwiki-mg			Fiteny							Malagasy \n" +
        "interwiki-ml			ഭാഷ								മലയാളം \n" +
        "interwiki-mr			भाषा								मराठी \n" +
        "interwiki-arz			لغه								مصرى \n" +
        "interwiki-mzn			زوون							مازِرونی \n" +
        "interwiki-ms			Bahasa							Bahasa Melayu \n" +
        "interwiki-cdo			Ngṳ̄-ngiòng						Mìng-dĕ̤ng-ngṳ̄ \n" +
        "interwiki-mn			Хэл судлал						Монгол \n" +
        "interwiki-my			ဘာသာစကား							မြန်မာဘာသာ \n" +
        "interwiki-nah			Tlahtōlli (tlahtōlmatiliztli)	Nāhuatl \n" +
        "interwiki-nl			Taal							Nederlands \n" +
        "interwiki-nds-nl		Taol							Nedersaksisch \n" +
        "interwiki-ne			भाषा								नेपाली \n" +
        "interwiki-new			भाषा								नेपाल भाषा \n" +
        "interwiki-ja			言語							日本語 \n" +
        "interwiki-nap			Lengua							Nnapulitano \n" +
        "interwiki-frr			Spräke (iinjtål)				Nordfriisk \n" +
        "interwiki-pih			Laenghwij						Norfuk / Pitkern \n" +
        "interwiki-no			Språk							‪Norsk (bokmål)‬ \n" +
        "interwiki-nn			Språk							‪Norsk (nynorsk)‬ \n" +
        "interwiki-nrm			Laungue							Nouormand \n" +
        "interwiki-nov			Lingues							Novial \n" +
        "interwiki-oc			Lenga							Occitan \n" +
        "interwiki-mhr			Йылме							Олык Марий \n" +
        "interwiki-pnb			بولی							پنجابی \n" +
        "interwiki-pap			Idioma							Papiamentu \n" +
        "interwiki-ps			ژبه								پښتو \n" +
        "interwiki-tpi			Tokples							Tok Pisin \n" +
        "interwiki-pl			Język (mowa)					Polski \n" +
        "interwiki-pt			Linguagem						Português \n" +
        "interwiki-ksh			Sprooch							Ripoarisch \n" +
        "interwiki-ro			Limbă (comunicare)				Română \n" +
        "interwiki-rmy			Chhib							Romani \n" +
        "interwiki-rm			Lingua							Rumantsch \n" +
        "interwiki-qu			Rimay							Runa Simi \n" +
        "interwiki-ru			Язык							Русский \n" +
        "interwiki-rue			Язык							Русиньскый \n" +
        "interwiki-sah			Тыл								Саха тыла \n" +
        "interwiki-se			Giella							Sámegiella \n" +
        "interwiki-sc			Limbas							Sardu \n" +
        "interwiki-sco			Leid							Scots \n" +
        "interwiki-stq			Sproake							Seeltersk \n" +
        "interwiki-scn			Lingua (parràta)				Sicilianu \n" +
        "interwiki-si			භාෂාව								සිංහල \n" +
        "interwiki-simple		Language						Simple English \n" +
        "interwiki-sk			Jazyk (lingvistika)				Slovenčina \n" +
        "interwiki-cu			Ѩꙁꙑкъ							Словѣ́ньскъ / ⰔⰎⰑⰂⰡⰐⰠⰔⰍⰟ \n" +
        "interwiki-sl			Jezik (sredstvo sporazumevanja)	Slovenščina \n" +
        "interwiki-ckb			زمان							کوردی \n" +
        "interwiki-srn			Tongo							Sranantongo \n" +
        "interwiki-sr			Језик							Српски / Srpski \n" +
        "interwiki-sh			Jezik							Srpskohrvatski / Српскохрватски \n" +
        "interwiki-su			Basa							Basa Sunda \n" +
        "interwiki-fi			Kieli							Suomi \n" +
        "interwiki-sv			Språk							Svenska \n" +
        "interwiki-tl			Wika							Tagalog \n" +
        "interwiki-ta			மொழி								தமிழ் \n" +
        "interwiki-tt			Тел								Татарча/Tatarça \n" +
        "interwiki-te			భాష								తెలుగు \n" +
        "interwiki-th			ภาษา							ไทย \n" +
        "interwiki-tg			Забон (суxан)					Тоҷикӣ \n" +
        "interwiki-chr			ᎦᏬᏂᎯᏍᏗ							ᏣᎳᎩ \n" +
        "interwiki-tr			Dil (lisan)						Türkçe \n" +
        "interwiki-tk			Dil								Türkmençe \n" +
        "interwiki-uk			Мова							Українська \n" +
        "interwiki-ur			لسان							اردو \n" +
        "interwiki-vec			Łéngua							Vèneto \n" +
        "interwiki-vi			Ngôn ngữ						Tiếng Việt \n" +
        "interwiki-vo			Pük								Volapük \n" +
        "interwiki-fiu-vro		Keeleq							Võro \n" +
        "interwiki-wa			Lingaedje						Walon \n" +
        "interwiki-zh-classical	語言							文言 \n" +
        "interwiki-war			Yinaknan						Winaray \n" +
        "interwiki-wo			Kàllaama						Wolof \n" +
        "interwiki-wuu			言话							吴语 \n" +
        "interwiki-yi			שפראך							ייִדיש \n" +
        "interwiki-yo			Èdè								Yorùbá \n" +
        "interwiki-zh-yue		語言							粵語 \n" +
        "interwiki-diq			Zıwan (lısan)					Zazaki \n" +
        "interwiki-zea			Taele							Zeêuws \n" +
        "interwiki-bat-smg		Kalba							Žemaitėška \n" +
        "interwiki-zh			语言							中文 \n" +
        "";

    public static void main(String[] args) throws Exception {
            new ChartFontTest(args);
    }

    public ChartFontTest(String[] args) throws Exception {
        String[] fonts = {"Droid Sans Fallback", "SansSerif"};
        JFreeChart chart = ChartFactory.createBarChart3D(language, // chart title
                null, // domain axis label
                "產品力", // range axis label
                new DefaultCategoryDataset(), // data
                PlotOrientation.VERTICAL, // orientation
                false, // include legend
                false, // tooltips?
                false // URLs?
                );

        if (0 < args.length) fonts = args;
        for(String fontname: fonts) {
            applyChartTheme(chart,fontname);
            BufferedImage bi = chart.createBufferedImage(1000, 5500);
            javax.imageio.ImageIO.write(bi, "png", new File(fontname+".png"));
        }
    }

    static void applyChartTheme(JFreeChart chart, String fontname) {
        final StandardChartTheme chartTheme = (StandardChartTheme)org.jfree.chart.StandardChartTheme.createJFreeTheme();

        //if (Locale.getDefault().getLanguage().equals(Locale.CHINESE.getLanguage())) {
            final Font oldExtraLargeFont = chartTheme.getExtraLargeFont();
            final Font oldLargeFont = chartTheme.getLargeFont();
            final Font oldRegularFont = chartTheme.getRegularFont();
            final Font oldSmallFont = chartTheme.getSmallFont();

            final Font extraLargeFont = new Font(fontname, oldExtraLargeFont.getStyle(), oldExtraLargeFont.getSize());
            final Font largeFont = new Font(fontname, oldLargeFont.getStyle(), oldLargeFont.getSize());
            final Font regularFont = new Font(fontname, oldRegularFont.getStyle(), oldRegularFont.getSize());
            final Font smallFont = new Font(fontname, oldSmallFont.getStyle(), oldSmallFont.getSize());

            chartTheme.setExtraLargeFont(extraLargeFont);
            chartTheme.setLargeFont(largeFont);
            chartTheme.setRegularFont(regularFont);
            chartTheme.setSmallFont(smallFont);
        //}

        chartTheme.apply(chart);
        chart.setTextAntiAlias(true);
    }
}
