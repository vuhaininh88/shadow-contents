package com.uzabase.shadow.shareholder;

import com.uzabase.shadow.GlobalId;
import com.uzabase.shadow.entity.common.speeda.ShrHld;
import com.uzabase.shadow.entity.common.speeda.ShrHld_;
import com.uzabase.shadow.shareholders.Shareholders;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Named
public class ShareholdersRepository {

    @Inject
    private ShareholdersFactory factory;
    @Inject
    private EntityManager entityManager;

    public Shareholders findByGlobalId(GlobalId id) {
        CriteriaBuilder b = entityManager.getCriteriaBuilder();
        CriteriaQuery<ShrHld> query = b.createQuery(ShrHld.class);

        query.where(shareholdersDetectionPredicates(b, query.from(ShrHld.class), id));

        return factory.create(entityManager.createQuery(query).getResultList());
    }

    private Predicate[] shareholdersDetectionPredicates(CriteriaBuilder builder, Root<ShrHld> root, GlobalId globalId) {
        return new Predicate[]{
                builder.equal(root.get(ShrHld_.globalId), globalId.getValue())};
    }
}
