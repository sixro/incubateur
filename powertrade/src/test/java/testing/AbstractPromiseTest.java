package testing;

import org.jdeferred.Promise;

public abstract class AbstractPromiseTest {

	protected <D, F extends Throwable, P> D runAndWait(Promise<D, F, P> promise) throws F, InterruptedException {
		final DataContainer<D> dataContainer = new DataContainer<>();
		final DataContainer<F> exceptionContainer = new DataContainer<>();
		promise
			.done(data -> dataContainer.data = data)
			.fail(t -> exceptionContainer.data = t)
			.waitSafely();
		if (exceptionContainer.data != null)
			throw exceptionContainer.data;
		return dataContainer.data;
	}

	private static class DataContainer<D> {
		public D data = null;
	}

}
