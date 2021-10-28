package ro.sci.temasapt6;

import ro.sci.temasapt6.libraryCatalog.book.*;
import ro.sci.temasapt6.libraryCatalog.book.comparator.AlbumComparatorByAuthorOrName;
import ro.sci.temasapt6.libraryCatalog.book.comparator.AlbumComparatorByPages;
import ro.sci.temasapt6.libraryCatalog.book.comparator.NovelComparatorByAuthorOrName;
import ro.sci.temasapt6.libraryCatalog.book.comparator.NovelComparatorByPages;

import java.util.Arrays;
import java.util.TreeSet;

public class Main {
    private static NovelComparatorByAuthorOrName novelComparatorByAuthorOrName = new NovelComparatorByAuthorOrName();
    private static NovelComparatorByPages novelComparatorByPages = new NovelComparatorByPages();
    private static AlbumComparatorByAuthorOrName albumComparatorByAuthorOrName = new AlbumComparatorByAuthorOrName();
    private static AlbumComparatorByPages albumComparatorByPages = new AlbumComparatorByPages();

    public static void main(String[] args) {

        Novel n1 = new Novel("Morometii", "Marin Preda", 142, NovelType.DRAMA);
        Novel n2 = new Novel("Cel mai iubit dintre pamanteni", "Marin Preda", 142, NovelType.DRAMA);
        Novel n3 = new Novel( "Ion","Liviu Rebreanu", 175, NovelType.MYSTERY);
        Novel n4 = new Novel( "Ciuleanda", "Liviu Rebreanu",115, NovelType.AUTOBIOGRAPHICAL);
        Novel n5 = new Novel( "Baltagul", "Mihail Sadoveanu",115, NovelType.DRAMA);
        Novel n6 = new Novel( "Fratii Jderi", "Mihail Sadoveanu",115, NovelType.HISTORICAL);

        Student a1 = new Student("Iconic Rock Album","Smith", 84, PaperQuality.MATTE);
        Student a2 = new Student("DiscoverRomania","G. Avanu", 84, PaperQuality.LUSTRE);
        Student a3 = new Student("Portraits","G. Avanu", 84, PaperQuality.SILK);


        TreeSet<Novel> NovelListByName = new TreeSet<>(novelComparatorByAuthorOrName);
        NovelListByName.addAll(Arrays.asList(n1, n2, n3, n4, n5, n6));

        for(Novel n : NovelListByName){
            LibraryUtil.setNovelList(n);
        }

        TreeSet<Student> AlbumListByName = new TreeSet<>(albumComparatorByAuthorOrName);
        AlbumListByName.addAll(Arrays.asList(a1, a2, a3));

        for(Student a : AlbumListByName){
            LibraryUtil.setAlbumList(a);
        }

        LibraryUtil.listNovels();
        LibraryUtil.removeNovel(n2);
        LibraryUtil.listNovels();

        LibraryUtil.albumList();
        LibraryUtil.removeAlbum(a2);
        LibraryUtil.albumList();

    }
}