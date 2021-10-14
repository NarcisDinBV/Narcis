package ro.sci.temasapt6.libraryCatalog.book;

import java.util.ArrayList;
import java.util.List;

public class LibraryUtil {
    static List<Novel> novelList = new ArrayList<>();
    static List<Album> albumList = new ArrayList<>();

    public static void setNovelList(Novel novel) {
        novelList.add(novel);
    }

    public static void setAlbumList(Album album) {
        albumList.add(album);
    }

    public static void listNovels() {
        for (Novel n : novelList) {
            System.out.println(n);
        }
    }

    public static void removeNovel(Novel novelToBeRemoved) {
        for (Novel n : novelList) {
            if (n.getAuthor().equals(novelToBeRemoved.getAuthor()) && n.getName().equals(novelToBeRemoved.getName())) {
                novelList.remove(novelToBeRemoved);
                break;
            }
        }
        System.out.println("You have removed from the list " + novelToBeRemoved);

    }
//---------------------------------------album--------------------------------------------

    public static void albumList() {
        for (Album a : albumList) {
            System.out.println(a);
        }
    }

    public static void removeAlbum(Album albumToBeRemoved) {
        for (Album a : albumList) {
            if (a.getAuthor().equals(albumToBeRemoved.getAuthor()) && a.getName().equals(albumToBeRemoved.getName())) {
                albumList.remove(albumToBeRemoved);
                break;
            }
        }
        System.out.println("You have removed from the list " + albumToBeRemoved);
    }
}
