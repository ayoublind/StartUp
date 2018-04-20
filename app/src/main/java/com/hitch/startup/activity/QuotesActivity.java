package com.hitch.startup.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.hitch.startup.R;
import com.hitch.startup.adapter.QuotesFragmentPagerAdapter;
import com.hitch.startup.app.ShadowTransformer;

/**
 * Created by XWSPH on 08/08/2017.
 */

public class QuotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quotes_activity);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        QuotesFragmentPagerAdapter pagerAdapter = new QuotesFragmentPagerAdapter(getSupportFragmentManager(), dpToPixels(2, this));
        ShadowTransformer fragmentCardShadowTransformer = new ShadowTransformer(viewPager, pagerAdapter);
        fragmentCardShadowTransformer.enableScaling(true);

        viewPager.setAdapter(pagerAdapter);
        viewPager.setPageTransformer(false, fragmentCardShadowTransformer);
        viewPager.setOffscreenPageLimit(3);
    }


    /**
     * Change value in dp to pixels
     * @param dp
     * @param context
     * @return
     */
    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }



     /*
    1. "Man is so made that when anything fires his soul, impossibilities vanish." - Jean De La Fontaine


2. "All that we send into the lives of others comes back into our own." - Edwin Markham


3. "The best way out is always through." - Robert Frost


4. "Sooner or later, those who win are those who think they can." - Richard Bach


5. "Shallow men believe in luck. Strong men believe in cause and effect." - Ralph Waldo Emerson


6. "You were born an original. Don't die a copy." - John Mason


7. "The secret of greatness is simple: do better work than any other man in your field - and keep on doing it." - Wilfred A. Peterson


8. "When you live for a strong purpose, then hard work isn't an option. It's a necessity." - Steve Pavlina


9. "Courage doesn't always roar. Sometimes courage is the little voice at the end of the day that says I'll try again tomorrow." - Mary Anne Radmacher


10. "Success is focusing the full power of all you are on what you have a burning desire to achieve." - Wilfred Peterson


11. "If you start to think the problem is 'out there,' stop yourself. That thought is the problem." - Stephen Covey


12. "The world is a great mirror. It reflects back to you what you are. If you are loving, if you are friendly, if you are helpful, the world will prove loving and friendly and helpful to you. The world is what you are." - Thomas Dreier


13. "What I know for sure is that what you give comes back to you." - Oprah Winfrey


14. "With self-discipline most anything is possible." - Theodore Roosevelt


15. "Do not wait; the time will never be 'just right'. Start where you stand, and work with whatever tools you may have at your command, and better tools will be found as you go along." - Napoleon Hill


16. "An enterprising person is one who sees opportunity in all areas of life." - Jim Rohn


17. "Failure is simply the opportunity to begin again, this time more intelligently." - Henry Ford


18. "The best way to predict the future is to create it." - Abraham Lincoln


19. "Nobody can go back and start a new beginning, but anyone can start today and make a new ending." - Maria Robinson


20. "The best and most beautiful things in the world cannot be seen or even touched - they must be felt with the heart." - Helen Keller


21. "The purpose of life is to live it, to taste experience to the utmost, to reach out eagerly and without fear for newer and richer experience." - Eleanor Roosevelt


22. "The starting point of all achievement is desire. Weak desire brings weak results." - Napoleon Hill


23. "At the center of your being you have the answer; you know who you are and you know what you want." - Lao Tzu


24. "I'm a great believer in luck, and I find the harder I work the more I have of it." - Thomas Jefferson


25. "Concentrate all your thoughts on the task at hand. The sun's rays do not burn until brought to a focus." - Alexander Graham Bell


26. "If you accept the expectations of others, especially negative ones, then you never will change the outcome." - Michael Jordan


27. "You see, in life, lots of people know what to do, but few people actually do what they know. Knowing is not enough! You must take action." - Tony Robbins


28. "Brick walls are not there to keep us out; brick walls are there to give us a chance to show how badly we want something." - Randy Pausch


29. "When you arise in the morning, think of what a precious privilege it is to be alive - to breathe, to think, to enjoy, to love." - Marcus Aurelius


30. "Your own resolution to succeed is more important than any other one thing." - Abraham Lincoln


31. "Do not dwell in the past, do not dream of the future, concentrate the mind on the present moment." - Buddha


32. "It is not because things are difficult that we do not dare, It is because we do not dare that they are difficult." - Seneca


33. "It matters not what a person is born, but whom they choose to be." - J.K. Rowling
     */
}
