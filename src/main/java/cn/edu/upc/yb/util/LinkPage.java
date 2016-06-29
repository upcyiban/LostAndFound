package cn.edu.upc.yb.util;

import cn.edu.upc.yb.template.PageItem;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyljj on 2016/6/28.
 */
public class LinkPage<T> {

    public static final int MAX_PAGE_ITEM_DISPLAY = 3;

    @Autowired
    private PageItem pageItem;

    @Autowired
    private Page<T> page;

    @Autowired
    private List<PageItem> items;

    @Autowired
    private int number;

    @Autowired
    private String url;


    public LinkPage(Page<T> page, String url) {
        this.page = page;
        this.url = url;
        items = new ArrayList<>();
        number = page.getNumber();

        int start, size;
        if (page.getTotalPages() <= MAX_PAGE_ITEM_DISPLAY) {
            start = 1;
            size = page.getTotalPages();
        } else {
            int half = MAX_PAGE_ITEM_DISPLAY / 2;
            if (number + half <= MAX_PAGE_ITEM_DISPLAY) {
                // 2/6 -> 1,2,3,4,5
                start = 1;
            } else if (number + half >= page.getTotalPages()) {
                // 5/6 -> 2,3,4,5,6
                start = page.getTotalPages() - MAX_PAGE_ITEM_DISPLAY + 1;
            } else {
                // 4/6 -> 2,3,4,5,6
                start = number - half + 1;
            }
            size = MAX_PAGE_ITEM_DISPLAY;
        }

        for (int i = 0; i < size; i++) {
            items.add(new PageItem(start + i, (start + i) == (number + 1)));
        }
    }

    public List<T> getContent() {
        return page.getContent();
    }

    public int getSize() {
        return page.getSize();
    }

    public int getTotalPages() {
        return page.getTotalPages();
    }

    public boolean isFirst() {
        return page.isFirst();
    }

    public boolean isLast() {
        return page.isLast();
    }

    public boolean isHasPrevious() {
        return page.hasPrevious();
    }

    public boolean isHasNext() {
        return page.hasNext();
    }

    public static int getMaxPageItemDisplay() {
        return MAX_PAGE_ITEM_DISPLAY;
    }

    public PageItem getPageItem() {
        return pageItem;
    }

    public Page<T> getPage() {
        return page;
    }

    public List<PageItem> getItems() {
        return items;
    }

    public int getNumber() {
        return number;
    }

    public String getUrl() {
        return url;
    }
}
