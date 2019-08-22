package cn.com.dxk.management.vo;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * 〈layui-table  后台异步获取数据对应实体类〉
 *
 * @author Dingxk
 * @create 2019/8/22
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LayUITableResponseVO<T> implements Serializable {
    private String code;

    private String msg;

    private Long count;

    private List<T> data;
}
