package versionControl;

import com.cooper.tracker.project.Project;
import com.cooper.tracker.project.ProjectController;
import com.cooper.tracker.project.ProjectHelper;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.nio.file.*;

public class HotKeyListener implements NativeKeyListener {

    final VersionControl versionControl = new VersionControl();
    final ProjectHelper projectHelper = new ProjectHelper();

    private void hardSave(KeyEvent e)
    {
        int id = e.getID();
        if(id == KeyEvent.KEY_TYPED)
        {
            char c = e.getKeyChar();
            if(c == KeyEvent.VK_F12)
            {
                System.out.println(c + " has been pressed");
                //versionControl.updateProject();
            }
        }
    }

    public void promptSave()
    {
        //TODO: prompt UI
        //specify project to update
        //this is a dummy item for now, but UI should be able to specify which proj to update
        Project project = new Project();
        String commitMessage = "this is a commit";
        Branch branch = new Branch();
        projectHelper.updateProject(project, commitMessage,branch);
        //versionControl.updateProject(branch,commitMessage);
    }



    public void nativeKeyPressed(NativeKeyEvent e) {
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

        if(e.getKeyCode() == NativeKeyEvent.VC_SCROLL_LOCK)
        {
            promptSave();
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException nativeHookException) {
                nativeHookException.printStackTrace();
            }
        }
    }


    public void nativeKeyReleased(NativeKeyEvent e) {
        System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
        System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
    }


//    public void promptSave(){
//        // idea is to listen in a designated working directory for a file to be updated, prompt user with version update/commit after they save.
//        // honestly a better strategy is probably the hotkey..
//        final Path path = FileSystems.getDefault().getPath(System.getProperty("user.home"), "Desktop");
//        System.out.println(path);
//        try (final WatchService watchService = FileSystems.getDefault().newWatchService()) {
//            final WatchKey watchKey = path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
//            while (true) {
//                final WatchKey wk = watchService.take();
//                for (WatchEvent<?> event : wk.pollEvents()) {
//                    //we only register "ENTRY_MODIFY" so the context is always a Path.
//                    final Path changed = (Path) event.context();
//                    System.out.println(changed);
//                    if (changed.endsWith("myFile.txt")) {
//                        System.out.println("My file has changed");
//                    }
//                }
//                // reset the key
//                boolean valid = wk.reset();
//                if (!valid) {
//                    System.out.println("Key has been unregistered");
//                }
//            }
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
