import com.meethong.dao.UserDaoImpl;
import com.meethong.dao.UserDaoMysqlimpl;

import com.meethong.service.UserserviceImpl;

public class Mytest {

    public static void main(String[] args) {
        UserserviceImpl service = new UserserviceImpl();
        service.setUserDao( new UserDaoMysqlimpl() );
        service.setUserDao( new UserDaoImpl());
        service.getUser();
    }
}
