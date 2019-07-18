package by.pvt.service;

import by.pvt.dao.SystemUsersMapper;
import by.pvt.dto.SystemUsers;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


class SystemUsersService {

    private static Logger log = Logger.getLogger(SystemUsersService.class.getName());

    private SqlSessionFactory sqlSessionFactory;

    SystemUsersService() {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("by/pvt/service/mybatis-config.xml")
            );
        } catch (IOException e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    List<SystemUsers> getSystemUsers() {
        return sqlSessionFactory
                .openSession()
                .getMapper(SystemUsersMapper.class)
                .selectByExample(null);
    }

    void insertSystemUser(SystemUsers systemUser){
        SqlSession session = sqlSessionFactory.openSession(true);
        session.getMapper(SystemUsersMapper.class).insert(systemUser);
    }

    int updateSystemUser(SystemUsers systemUser) {
       return sqlSessionFactory
                .openSession(true)
                .getMapper(SystemUsersMapper.class)
                .updateByPrimaryKey(systemUser);
    }

    void deleteSystemUser(int id) {
        SqlSession session = sqlSessionFactory.openSession(true);
        session.getMapper(SystemUsersMapper.class).deleteByPrimaryKey(id);
    }
}