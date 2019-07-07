package com.spboot.util;

import com.spboot.bean.Groups;
import com.spboot.bean.PayRequestVo;
import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @Author WANG JI BO
 * @Date 2019/6/14 上午11:13
 * @Description
 **/
public class ValidationUtils {

    /**
     * 使用hibernate的注解来进行验证
     */
    private static Validator validator = Validation
            .byProvider(HibernateValidator.class).configure().failFast(false).buildValidatorFactory().getValidator();

    /**
     * 功能描述: <br>
     * 〈注解验证参数〉
     *
     * @param obj
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static List<String> validate(Object obj) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(obj, Groups.Add.class);
        // 抛出检验异常
        if (constraintViolations.size() > 0) {
            Iterator<ConstraintViolation<Object>> iterator = constraintViolations.iterator();
            while (iterator.hasNext()) {
                ConstraintViolation<Object> violation = iterator.next();
                //如果空
                //"00006","biz parameter error","参数错误！"

                //如果无效参数
                //"00006","biz parameter error","参数错误！"
                System.out.println(violation.getPropertyPath() + "==>" + violation.getMessage());
                System.out.println(violation.getExecutableReturnValue());
                System.out.println(violation.getInvalidValue());
            }
        }
        return null;
    }

    public static void main(String[] args) {
        PayRequestVo dto = new PayRequestVo();
        dto.setPayTime("123456789123456555");
        validate(dto);


    }
}
