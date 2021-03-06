/*
 * Copyright 2011-2016 David Karnok
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ix;

import rx.functions.*;

enum IxEmptyAction implements Action1<Object>, Action0 {
    INSTANCE;

    @SuppressWarnings("unchecked")
    public static <T> Action1<T> instance1() {
        return (Action1<T>)INSTANCE;
    }

    public static Action0 instance0() {
        return INSTANCE;
    }

    @Override
    public void call(Object t) {
        // deliberately no op
    }
    
    @Override
    public void call() {
        // deliberately no op
    }
    
}
