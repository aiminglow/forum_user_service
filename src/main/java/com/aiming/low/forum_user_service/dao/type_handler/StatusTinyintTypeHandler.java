package com.aiming.low.forum_user_service.dao.type_handler;

import com.aiming.low.forum_user_service.entity.Comment;
import com.aiming.low.forum_user_service.entity.ThreeStatus;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @ClassName StatusTinyintTypeHandler
 * @Description
 * @Author aiminglow
 */
@MappedTypes({ThreeStatus.class, Comment.CommentStatus.class})
@MappedJdbcTypes(JdbcType.TINYINT)
public class StatusTinyintTypeHandler<E extends Enum<E>> extends BaseTypeHandler<E> {

    private final Class<E> type;

    public StatusTinyintTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        if (type == ThreeStatus.class) {
            ps.setInt(i, ((ThreeStatus) parameter).getValue());
        } else if (type == Comment.CommentStatus.class) {
            ps.setInt(i, ((Comment.CommentStatus) parameter).getValue());
        } else {
            throw new IllegalArgumentException("Illegal type: " + type.getTypeName());
        }
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int value = rs.getInt(columnName);
        return toStatus(value);
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int value = rs.getInt(columnIndex);
        return toStatus(value);
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int value = cs.getInt(columnIndex);
        return toStatus(value);
    }

    public E toStatus(int value) {
        if (type == ThreeStatus.class) {
            return (E) ThreeStatus.fromValue(value);
        } else if (type == ThreeStatus.class) {
            return (E) Comment.CommentStatus.fromValue(value);
        } else {
            throw new IllegalArgumentException("Illegal type: " + type.getTypeName());
        }
    }
}
