package club.yiwuyu.zcgl.util.page;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageInfo;

public class PageHelper {

    private PageHelper() {
    }

    public static <T, S> PageResult<S> doSelectPage(PageParam<T> pageParam, ISelect select) {
        PageInfo<S> objectPageInfo = com.github.pagehelper.PageHelper.startPage(pageParam).doSelectPageInfo(select);
        PageResult<S> pageResult = BeanUtil.copyProperties(objectPageInfo, PageResult.class);
        pageResult.setList(objectPageInfo.getList());
        pageResult.setTotal(objectPageInfo.getTotal());
        return pageResult;
    }
}
