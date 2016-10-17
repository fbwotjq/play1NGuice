package util;

import org.hibernate.exception.ConstraintViolationException;
import play.db.jpa.JPAPlugin;


/**
 * Created by gregory on 2014. 11. 25..
 */
public class JpaUtil {

	/**
	 * MySQL 상에서 PK 또는 Unique Key의 Duplication에러인지 확인
	 *
	 * @param e
	 * @return
	 */
	public static boolean isDuplicationException(Exception e) {
		Throwable t = e.getCause();
		// catch org.hibernate.exception.ConstraintViolationException
		while ((t != null) && !(t instanceof ConstraintViolationException)) {
			t = t.getCause();
		}

		return t instanceof ConstraintViolationException;
	}

	/**
	 * isReadOnly = True로 설정된 Trasaction 영역 선언
	 *
	 * @param context
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	public static <T> T declareTrasaction(TxContext<T> context) throws Exception {
		return declareTrasaction(false, context);
	}

	public static <T> T declareTrasaction(boolean isReadOnly, TxContext<T> context) throws Exception {
		boolean isRollback = false;
		JPAPlugin.startTx(isReadOnly);
		try {
			return context.handle();
		} catch (Exception ex) {
			isRollback = true;
			throw ex;
		} finally {
			JPAPlugin.closeTx(isRollback);
		}
	}

	public static interface TxContext<T> {
		public T handle();
	}

}
