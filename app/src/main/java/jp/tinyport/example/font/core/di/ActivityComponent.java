package jp.tinyport.example.font.core.di;

import dagger.Subcomponent;
import jp.tinyport.example.font.MainActivity;

@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
}
