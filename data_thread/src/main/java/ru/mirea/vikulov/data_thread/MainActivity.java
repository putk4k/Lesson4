package ru.mirea.vikulov.data_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.concurrent.TimeUnit;

import ru.mirea.vikulov.data_thread.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        final Runnable runn1 = new Runnable() {
            public void run() {
                binding.tvInfo.setText("runn1");
            }
        };
        final Runnable runn2 = new Runnable() {
            public void run() {
                binding.tvInfo.setText("runn2");
            }
        };
        final Runnable runn3 = new Runnable() {
            public void run() {
                binding.tvInfo.setText("runn3");
            }
        };
        final Runnable runn4 = new Runnable() {
            public void run() {
                binding.tvInfo.setText("runOnUiThread - запускает указанное действие в потоке пользовательского интерфейса. " +
                        "Если текущий поток является потоком пользовательского интерфейса, то действие выполняется " +
                        "немедленно. Если текущий поток не является потоком пользовательского интерфейса, действие" +
                        " публикуется в очереди событий потока пользовательского интерфейса. \n" +
                        "postDelayed - добавляет выполняемый объект в очередь сообщений, который будет запущен" +
                        " по истечении указанного промежутка времени. Запускаемый файл будет выполняться в потоке" +
                        " пользовательского интерфейса. \n" +
                        "post - добавляет выполняемый объект в очередь. Запускаемый объект будет выполняться" +
                        " в потоке пользовательского интерфейса.");
            }
        };
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    runOnUiThread(runn1);
                    TimeUnit.SECONDS.sleep(1);
                    binding.tvInfo.postDelayed(runn3, 2000);
                    binding.tvInfo.post(runn2);
                    binding.tvInfo.postDelayed(runn4, 2100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

    }
}

