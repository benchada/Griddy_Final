/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.berkeley.boinc;

//import com.example.android.common.logger.Log;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.games.Games;

import edu.berkeley.boinc.common.view.SlidingTabLayout;

import java.util.Locale;

//import android.support.v7.app.ActionBarActivity;
//import android.support.v7.app.ActionBar;


public class SlidingTabsBasicFragment extends Fragment {



    SectionsPagerAdapter mSectionsPagerAdapter;
    private static final int RC_UNUSED = 5001;


    // static final String LOG_TAG = "SlidingTabsBasicFragment";

    /**
     * A custom {@link android.support.v4.view.ViewPager} title strip which looks much like Tabs present in Android v4.0 and
     * above, but is designed to give continuous feedback to the user when scrolling.
     */
    private SlidingTabLayout mSlidingTabLayout;

    /**
     * A {@link android.support.v4.view.ViewPager} which will be used in conjunction with the {@link SlidingTabLayout} above.
     */
    private ViewPager mViewPager;
    public int currentFrag=0;
    public static String personName;
    private static String ppURL;
    /**
     * Inflates the {@link android.view.View} which will be displayed by this {@link android.support.v4.app.Fragment}, from the app's
     * resources.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

/*
        currentFrag=getArguments().getString("section");
*/
      /*  Bundle bundle = getArguments();
        int SectionNum= bundle.getInt("Section");*/
      //  currentFrag= SectionNum;
   /*      personName = getArguments().getString("name");
           ppURL = getArguments().getString("Photo");*/
    /*    ppURL = ppURL.substring(0,
                ppURL.length() - 2)
                + 500;*/


        return inflater.inflate(R.layout.fragment_sample, container, false);
    }

    // BEGIN_INCLUDE (fragment_onviewcreated)
    /**
     * This is called after the {@link #onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)} has finished.
     * Here we can pick out the {@link android.view.View}s we need to configure from the content view.
     *
     * We set the {@link android.support.v4.view.ViewPager}'s adapter to be an instance of {@link SamplePagerAdapter}. The
     * {@link SlidingTabLayout} is then given the {@link android.support.v4.view.ViewPager} so that it can populate itself.
     *
     * @param view View created in {@link #onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)}
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // BEGIN_INCLUDE (setup_viewpager)
        // Get the ViewPager and set it's PagerAdapter so that it can display items
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // END_INCLUDE (setup_viewpager)

        // BEGIN_INCLUDE (setup_slidingtablayout)
        // Give the SlidingTabLayout the ViewPager, this must be done AFTER the ViewPager has had
        // it's PagerAdapter set.
        mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(mViewPager);
        // END_INCLUDE (setup_slidingtablayout)
    }




    // END_INCLUDE (fragment_onviewcreated)

    /**
     * The {@link android.support.v4.view.PagerAdapter} used to display pages in this sample.
     * The individual pages are simple and just display two lines of text. The important section of
     * this class is the {@link #getPageTitle(int)} method which controls what is displayed in the
     * {@link SlidingTabLayout}.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:

                    /*(BOINCActivity)getActivity()).openNavDrawer(); break;*/


                    if (currentFrag==0) {
                    /*
                        Context context= getActivity().getApplicationContext();

                        Toast.makeText(context, "Tasks Fragment", Toast.LENGTH_LONG).show();*/


                        return new TasksFragment();

                    }
                    else if (currentFrag==1) {

                /*        Context context= getActivity().getApplicationContext();

                        Toast.makeText(context, "Notices Fragment", Toast.LENGTH_LONG).show();*/
                        //    return new NoticesFragment();}
                        // else if (currentFrag== 2) return new ProjectsFragment();
/*
                    else if (currentFrag== 3) return new PrefsFragment();
*/
                    }
                   // else return new TasksFragment();
                case 1:
                    //Fragment for Ios Tab
                    return new LeaderBoard();
                case 2:
                    //Fragment for Windows Tab
                    return new Profile();

            }

            return null;

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }
    public static class Projects extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View projects = inflater.inflate(R.layout.projects_frag, container, false);
            ((TextView)projects.findViewById(R.id.textView)).setText("Projects");
            return projects;
        }
    }
  /*  public static void onShowLeaderboardsRequested(){
      *//*  startActivityForResult(Games.Leaderboards.getAllLeaderboardsIntent((BOINCActivity)getActivity().),
                RC_UNUSED)*//*

    }*/
    public static class Profile extends Fragment {

      TextView name;
      private ImageView imgProfilePic;


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

            View profile = inflater.inflate(R.layout.profile_frag, container, false);



            ((TextView)profile.findViewById(R.id.textView)).setText("leaderboard");


            profile.findViewById(R.id.show_leaderboards_button).setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    Intent intent = new Intent(getActivity(), tempActivity.class);
                    startActivity(intent);
                }
            });

            profile.findViewById(R.id.show_Achievements_button).setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    Intent intent = new Intent(getActivity(), tempActivity2.class);
                    startActivity(intent);
                }
            });

           // name= (TextView)profile.findViewById(R.id.textView);
          //  imgProfilePic = (ImageView) profile.findViewById(R.id.imageView2);

           // name.setText("Name : "+personName);

          /*  new LoadProfileImage(imgProfilePic).execute(ppURL);
            ImageView myImageView= imgProfilePic;*/

            return profile;
        }


/*
      private class LoadProfileImage extends AsyncTask<String, Void, Bitmap> {
          ImageView bmImage;


          public LoadProfileImage(ImageView bmImage) {
              this.bmImage = bmImage;
          }

          protected Bitmap doInBackground(String... urls) {
              String urldisplay = urls[0];
              Bitmap mIcon11 = null;
              try {
                  InputStream in = new java.net.URL(urldisplay).openStream();
                  mIcon11 = BitmapFactory.decodeStream(in);
                  //     roundedImage = new RoundImage(mIcon11);
                  //   imgProfilePic.setImageDrawable(roundedImage);

              } catch (Exception e) {
                  Log.e("Error", e.getMessage());
                  e.printStackTrace();
              }
              return mIcon11;
          }

          protected void onPostExecute(Bitmap result) {
              bmImage.setImageBitmap(result);
          }
      }
*/

  }
    public  class LeaderBoard extends Fragment{




    /*    public interface Listener {
            public void onShowLeaderboardsRequested();

        }
        Listener mListener = null;
*/


/*
        public void setListener(Listener l) {
            mListener = l;
        }
*/
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View leaderboard = inflater.inflate(R.layout.leaderboard_frag, container, false);
            ((TextView)leaderboard.findViewById(R.id.textView)).setText("Profile");


            leaderboard.findViewById(R.id.show_leaderboards_button).setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    Intent intent = new Intent(getActivity(), ProfileActivity.class);
                    startActivity(intent);
                }
            });


            return leaderboard;
        }


 /*       @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.show_leaderboards_button:
          //          mListener.onShowLeaderboardsRequested();
            }
        }*/
    }


    class SamplePagerAdapter extends PagerAdapter {

        /**
         * @return the number of pages to display
         */
        @Override
        public int getCount() {
            return 3;
        }

        /**
         * @return true if the value returned from {@link #instantiateItem(android.view.ViewGroup, int)} is the
         * same object as the {@link android.view.View} added to the {@link android.support.v4.view.ViewPager}.
         */
        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }

        // BEGIN_INCLUDE (pageradapter_getpagetitle)
        /**
         * Return the title of the item at {@code position}. This is important as what this method
         * returns is what is displayed in the {@link SlidingTabLayout}.
         * <p>
         * Here we construct one using the position value, but for real application the title should
         * refer to the item's contents.
         */
        @Override
        public CharSequence getPageTitle(int position) {
            String title="Default";
            switch (position) {
                case 0: title = "Tasks";
                    break;
                case 1: title = "Leaderboard";
                    break;
                case 2: title = "Profile";
                    break;
            }
            return title;
        }
        // END_INCLUDE (pageradapter_getpagetitle)

        /**
         * Instantiate the {@link android.view.View} which should be displayed at {@code position}. Here we
         * inflate a layout from the apps resources and then change the text view to signify the position.
         */


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // Inflate a new layout from our resources
            View view = getActivity().getLayoutInflater().inflate(R.layout.pager_item,
                    container, false);
            // Add the newly created View to the ViewPager
            container.addView(view);

            // Retrieve a TextView from the inflated View, and update it's text
            TextView title = (TextView) view.findViewById(R.id.item_title);
            title.setText(String.valueOf(position + 1));

/*
            Log.i(LOG_TAG, "instantiateItem() [position: " + position + "]");
*/

            // Return the View
            return view;
        }

        /**
         * Destroy the item from the {@link android.support.v4.view.ViewPager}. In our case this is simply removing the
         * {@link android.view.View}.
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
//            Log.i(LOG_TAG, "destroyItem() [position: " + position + "]");
        }

    }
}
