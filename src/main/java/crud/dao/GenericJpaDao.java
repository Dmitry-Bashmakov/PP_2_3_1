package crud.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Transactional
public class GenericJpaDao < T extends Serializable>
        extends AbstractJpaDAO< T > implements IGenericDao< T >{
    //
}
