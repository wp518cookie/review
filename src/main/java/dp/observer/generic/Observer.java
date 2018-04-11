package dp.observer.generic;

/**
 * Created by Administrator on 2018/4/11.
 * @Param <S> Observable
 * @Param <O> Observer
 * @Param <A> Action
 */
public interface Observer <S extends Observable<S, O, A>, O extends Observer<S, O, A>, A> {
    void update(S subject, A argument);
}
